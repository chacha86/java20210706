package example.board.article;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ArticleFileManager {

	// 게시물을 받아서 파일로 저장
	public void writeArticle(Article article) {
		
		try {
			FileWriter fw = new FileWriter("c:/test/article/article1.txt");
			
			fw.write("번호:" + article.getId()+"," );
			fw.write("제목:" + article.getTitle() + ",");
			fw.write("내용:" + article.getBody() + ",");
			fw.write("작성자:" + article.getWriter() + ",");
			fw.write("작성일:"+ article.getRegDate() + ",");
			fw.write("조회수:" + article.getHit()+",");
			
			fw.close();

		} catch (Exception e) {
			System.out.println("게시물 데이터 파일 저장중 에러 발생");
			e.printStackTrace();
		}
		
	}
	
	
	// 파일을 읽어서 게시물 객체로 가져오기
	public Article readArticle() {
		Article article = null;
		
		
		
		try {
			FileReader fr = new FileReader("c:/test/article/article1.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();			
			
			String[] rst = str.split(",");
			String[] rst2 = rst[0].split(":");
			int id = Integer.parseInt(rst2[1]);
			
			rst2 = rst[1].split(":");
			String title = rst2[1];
			
			rst2 = rst[2].split(":");
			String body = rst2[1];
			
			rst2 = rst[3].split(":");
			String writer = rst2[1];
			
			rst2 = rst[4].split(":");
			String regDate = rst2[1];
			
			rst2 = rst[5].split(":");
			int hit = Integer.parseInt(rst2[1]);			
			article = new Article(id, title, body, writer, regDate, hit);
			
			
		} catch(Exception e) {
			System.out.println("파일 입력중 에러");
		}
		
		return article;
	}
}

