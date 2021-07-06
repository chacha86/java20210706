package example.board.article;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import example.board.App;

public class ArticleManager {

	private int articleId = 1; // 게시물 번호
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Article> articles = new ArrayList<Article>();
	private ArrayList<Reply> replies = new ArrayList<Reply>();
	private ArrayList<Like> likes = new ArrayList<Like>();
	private ArticleFileManager afm = new ArticleFileManager();
	
	// ===============================================================
	public void readProcess(Article article) {
		while (true) {
			System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) :");
			int cmd = Integer.parseInt(sc.nextLine());

			if (cmd == 1) {
				System.out.println("댓글 내용을 입력해주세요 : ");
				String rbody = sc.nextLine();

				Reply reply = new Reply(1, article.getId(), rbody, App.loginedMember.getNickname(), "2021.06.24");

				replies.add(reply);

				// 댓글 추가된 화면 다시 보여주기
				printArticle(article);

			} else if (cmd == 2) {
				like(article);
			} else if (cmd == 5) {
				System.out.println("게시물 목록으로 돌아갑니다.");
				break;
			}
		}
	}

	// ===============================================================
	void like(Article article) {
		// 좋아요 -> 로그인한 현재 회원이 지금 보고 있는 게시물에 좋아요 체크를 했는가
		// 저장소에 게시물 번호 + 회원 번호 있는지 없는지로 판단.

		// 해당 좋아요 정보가 없을 때만 추가.
		Like result = getLikeByMember(article);

		if (result == null) {
			Like like = new Like(1, article.getId(), App.loginedMember.getMemberId(), "2021.06.24");

			likes.add(like);
			System.out.println("해당 게시물을 좋아합니다.");

		} else {
			likes.remove(result);
			System.out.println("해당 게시물의 좋아요를 해제합니다.");
		}

		printArticle(article);

	}

	// ===============================================================
	public void printArticleDetail() {
//		System.out.println("상세보기 할 게시물 번호를 입력해주세요 : ");
//		int id = Integer.parseInt(sc.nextLine());
//		int target = getIndexById(id);

		//if (target != -1) {
			//Article article = articles.get(target);
		    Article article = afm.readArticle();
		
			printArticle(article);
//
//			readProcess(article);
		//}
	}

	// ===============================================================
	public void search(Pagination pagination) {
		System.out.println("검색 키워드를 입력해주세요 : ");
		String keyword = sc.nextLine();

		ArrayList<Article> searchedList = new ArrayList<Article>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if (article.getTitle().contains(keyword)) {
				searchedList.add(article);
			}
		}

		list(searchedList, pagination);
	}

	// ===============================================================
	public void printNotFound() {
		System.out.println("없는 게시물입니다.");
	}

	// ===============================================================
	public void printHelp() {
		System.out.println("========================");
		System.out.println("help : 도움말");
		System.out.println("add : 데이터 추가");
		System.out.println("read : 데이터 조회");
		System.out.println("update : 데이터 수정");
		System.out.println("delete : 데이터 삭제");
		System.out.println("exit : 프로그램 종료");
		System.out.println("========================");
	}

	// ===============================================================
	public void add() {

		System.out.println("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.println("내용을 입력해주세요 : ");
		String body = sc.nextLine();

		Article article = new Article(articleId, title, body, "20210608", "익명", 0);
		//articles.add(article); // 파일 저장
		afm.writeArticle(article);

		articleId++;
	}

	// ===============================================================
	public int getLikeCountByArticleId(int articleId) {
		int result = 0;

		for (int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i);
			if (like.getParentId() == articleId) {
				result++;
			}
		}

		return result;
	}
	// ===============================================================

	public Like getLikeByMember(Article article) {

		Like target = null;

		for (int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i);

			if (like.getParentId() == article.getId() && App.loginedMember.getMemberId() == like.getMemberId()) {
				target = like;
				break;
			}

		}

		return target;
	}

	// ===============================================================
	public void printArticle(Article article) {
		System.out.println("===========" + article.getId() + "번 게시물 상세보기 ==========");
		System.out.println("번호 : " + article.getId());
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getBody());
		System.out.println("작성자 : " + article.getWriter());
		System.out.println("등록날짜 : " + article.getRegDate());
		System.out.println("조회수 : " + article.getHit());

		Like like = getLikeByMember(article); // 1. 로그인한 유저의 좋아요가 존재하는가
		int count = getLikeCountByArticleId(article.getId());
		// 2. 이 게시물에 좋아요 체크된 개수

		if (like == null) {
			System.out.println("좋아요 : ♡ " + count);
		} else {
			System.out.println("좋아요 : ♥ " + count);
		}
		System.out.println("============================");
		System.out.println("======= 댓글========");
		for (int i = 0; i < replies.size(); i++) {
			Reply reply = replies.get(i);

			if (reply.getParentId() == article.getId()) {
				System.out.println("내용 : " + reply.getBody());
				System.out.println("작성자 : " + reply.getNickname());
				System.out.println("작성일 : " + reply.getRegDate());
				System.out.println("===================");
			}

		}
	}

	// ===============================================================
	public void list(ArrayList<Article> list, Pagination pagination) {
		
		if (articles.size() == 0) {
			System.out.println("저장된 게시물이 없습니다.");
		} else {
			System.out.println("============================");
			for (int i = pagination.getStartIdx(); i < pagination.getEndIdx(); i++) {
				
				Article article = list.get(i);
				System.out.println("번호 : " + article.getId());
				System.out.println("제목 : " + article.getTitle());
				System.out.println("작성자 : " + article.getWriter());
				System.out.println("등록날짜 : " + article.getRegDate());
				System.out.println("조회수 : " + article.getHit());
				System.out.println("============================");
			}
			
			for(int i = pagination.getStartPageNo(); i <= pagination.getEndPageNo(); i++) {
				if(i == pagination.getCurrentPageNo()) {
					System.out.print("[" + i + "] ");
				}
				else {
					System.out.print(i + " ");				
				}
			}
			System.out.println();

		}
	}

	// ===============================================================
	public void update() {
		System.out.println("수정할 게시물 번호를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());

		int i = getIndexById(id);

		if (i != -1) {
			System.out.println("새제목을 입력해주세요 : ");
			String title = sc.nextLine();
			System.out.println("새내용을 입력해주세요 : ");
			String body = sc.nextLine();

			Article newArticle = new Article(id, title, body, "20210608", "익명", 0);

			articles.set(i, newArticle);
		}

	}

//	
//	//===============================================================
//	// 게시물을 삭제하는 메서드
	public void delete() {
		System.out.println("삭제할 게시물 번호를 입력해주세요 : ");
		int id = Integer.parseInt(sc.nextLine());

		int i = getIndexById(id);

		if (i != -1) {
			articles.remove(i);
		}

	}

	// ===============================================================
	// 게시물의 번호를 매개변수로 받아 해당 게시물의 저장 위치(index)를 찾아주는 메서드
	public int getIndexById(int id) {

		int targetIndex = -1;

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId() == id) {
				targetIndex = i;
			}
		}

		// 게시물 찾지 못했을 때.
		if (targetIndex == -1) {
			printNotFound();
		}

		return targetIndex;
	}

	// ===============================================================
	public void makeTestData() {

		Article a1 = new Article(1, "제목1", "내용1", "20210608", "홍길동", 30);
		Article a2 = new Article(2, "제목2", "내용2", "20210608", "홍길순", 10);
//		Article a3 = new Article(3, "제목3", "내용3", "20210608", "임꺽정", 20);
//		Article a4 = new Article(4, "제목4", "내용4", "20210708", "홍길동", 30);
//		Article a5 = new Article(5, "제목5", "내용5", "20210708", "홍길순", 10);
//		Article a6 = new Article(6, "제목6", "내용6", "20210708", "임꺽정", 20);

		articles.add(a1);
		articles.add(a2);
//		articles.add(a3);
//		articles.add(a4);
//		articles.add(a5);
//		articles.add(a6);

	}

	public void sort(Pagination pagination) {
		// 조회수
		// 오름차순 / 내림차순
		System.out.println("무엇으로 정렬을 할까요? : 1. 조회수, 2. 제목");
		int sortTarget = Integer.parseInt(sc.nextLine());

		System.out.println("어떤 정렬을 할까요? : 1. 오름차순, 2. 내림차순");
		int sortType = Integer.parseInt(sc.nextLine());

		ArticleComparator ac = new ArticleComparator();
		ac.setSortType(sortType);
		ac.setSortTarget(sortTarget);

		Collections.sort(articles, ac);
		list(articles, pagination);

	}

	public void page(Pagination pagination) {
		
		while (true) {
			System.out.println("페이징 명령어를 입력해주세요 ((1 : 이전,  2 : 다음,  3 : 선택,  4 : 뒤로가기): ");
			int pageCmd = Integer.parseInt(sc.nextLine());

			int currentPageNo = pagination.getCurrentPageNo();
			
			if (pageCmd == 1) {
				pagination.setCurrentPageNo(--currentPageNo);
			} else if (pageCmd == 2) {
				pagination.setCurrentPageNo(++currentPageNo);
			} else if (pageCmd == 3) {

			} else if (pageCmd == 4) {
				break;
			}
			
			list(articles, pagination);
		}

	}

	// ===============================================================
	// getter
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

}
