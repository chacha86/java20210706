package example.board.article;

public class Like {

	private int id; // 좋아요 번호
	private int parentId; // 좋아요 한 게시물의 번호
	private int memberId; // 좋아요 한 회원의 번호
	private String regDate; // 좋아요 체크한 날짜
	public Like(int id, int parentId, int memberId, String regDate) {
		super(); // 부모 생성자
		this.id = id;
		this.parentId = parentId;
		this.memberId = memberId;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
