package example.board.member;

import example.board.Controller;

public class MemberController extends Controller {
	MemberManager mm = new MemberManager();
	
	public MemberController() {
		 mm.makeTestData();
	}
	
	public void doCommand(String command) {

		if (command.equals("signup")) {
			mm.signup();

		} else if (command.equals("signin")) {
			mm.signin();

		} else if (command.equals("logout")) {
			
			if(isLogin()) {
		 		mm.logout();				
			}

		}
	}	
	
}
