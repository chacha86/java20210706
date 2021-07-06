package example.board.article;

// 댓글이라는 개념을 표현하고 실제로 데이터를 저장, 운반하기 위한 구조체 클래스 -> Data Transfer Object -> DTO (VO)
public class Reply {
	
	private int id; // 댓글번호
	private int parentId; // 원게시물 번호
	private String body; // 댓글 내용
	private String nickname; // 댓글 작성자
	private String regDate; // 댓글 작성일
	
	public Reply(int id, int parentId, String body, String nickname, String regDate) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.body = body;
		this.nickname = nickname;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
