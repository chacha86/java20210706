package example.board;

public abstract class Controller {

	public abstract void doCommand(String command);
	
	public boolean isLogin() {
		
		if (App.loginedMember != null) {
			return true;
		} else {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		}
	}

}
