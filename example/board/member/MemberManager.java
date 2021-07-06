package example.board.member;

import java.util.ArrayList;
import java.util.Scanner;

import example.board.App;
import example.board.article.Article;

public class MemberManager {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Member> members = new ArrayList<Member>();
	private int memberId = 1; // 회원 번호

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	// setter
	public void setMemberId(int a) {
		memberId = a;
	}

	// getter
	public int getMemberId() {
		return memberId;
	}

	public void logout() {
		App.loginedMember = null;
	}

	public void signin() {
		System.out.println("아이디를 입력해주세요 : ");
		String loginId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 : ");
		String loginPw = sc.nextLine();

		int isExist = 0;// 0 없다. 1 있다.

		for (int i = 0; i < members.size(); i++) {
			Member mb = members.get(i);
			if (mb.getLoginId().equals(loginId)) {
				isExist = 1;
				if (mb.getLoginPw().equals(loginPw)) {
					System.out.println(mb.getNickname() + "님 환영합니다!");

					App.loginedMember = mb;
				} else {
					System.out.println("비밀번호를 틀렸습니다!");
				}
			}
		}

		if (isExist == 0) {
			System.out.println("없는 아이디입니다.");
		}

	}

	public void signup() {

		System.out.println("아이디를 입력해주세요 : ");
		String loginId = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요 : ");
		String loginPw = sc.nextLine();
		System.out.println("닉네임을 입력해주세요 : ");
		String nickname = sc.nextLine();

		Member member = new Member(memberId, loginId, loginPw, nickname);
		members.add(member);

		memberId++;
	}

	public void makeTestData() {

		Member m1 = new Member(1, "hong123", "h1234", "홍길동");
		Member m2 = new Member(2, "lee123", "l1234", "이순신");
		
		members.add(m1);
		members.add(m2);
		
	}

}
