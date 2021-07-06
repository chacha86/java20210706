package example.board;

import java.util.Scanner;

import example.board.article.ArticleController;
import example.board.member.Member;
import example.board.member.MemberController;

public class App {
	
	Scanner sc = new Scanner(System.in);	

	// 로그인 정보 저장
	public static Member loginedMember = new Member(1, "hong123", "h1234", "홍길동");
	
	public void startProcess() {
		
		// controller가 요청 처리 가져갔으니까
		// 공통 처리 하고 각 모듈 컨트롤러를 사용
		ArticleController am = new ArticleController();
		MemberController mc = new MemberController();
		Controller controller = null;
		
		while (true) {
			
			if(loginedMember != null) {
				System.out.println("명령어를 입력해주세요 :[" + loginedMember.getLoginId() + "(" + loginedMember.getNickname() + ")]");
			}
			else {
				System.out.println("명령어를 입력해주세요 :");				
			}
			String command = sc.nextLine();
			
			String[] bits = command.split(" ");
			
			if(bits.length < 2) {
				System.out.println("잘못된 명령어입니다.");
				continue;
			}
			
			String module = bits[0]; // 모듈
			String function = bits[1]; // 기능		

			if(module.equals("article")) {
				controller = am;
			}
			else if(module.equals("member")) {
				
				controller = mc;
			}
			
			controller.doCommand(function);
			
			if (command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 			
		}
	}
}

