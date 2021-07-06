package example.board.member;

public class Member {
	
	private int memberId;
	private String loginId;
	private String loginPw;
	private String nickname;
	
	public Member(int memberId, String loginId, String loginPw, String nickname) {
		this.memberId = memberId;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}	
