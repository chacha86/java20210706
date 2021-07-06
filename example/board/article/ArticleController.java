package example.board.article;
import example.board.Controller;

public class ArticleController extends Controller {
	
	ArticleManager am = new ArticleManager();
	Pagination pagination; 
	
	public ArticleController() {
		am.makeTestData();
		pagination = new Pagination(am.getArticles().size());
	}
	
	public void doCommand(String command) {
		
		pagination.setTotalCount(am.getArticles().size());
		
		if (command.equals("help")) {
			am.printHelp();
			
		} 
		else if (command.equals("add")) {
			if(isLogin()) {
				am.add();		
			}
			
		}
		else if (command.equals("list")) {
			am.list(am.getArticles(), pagination);
			
		} 
		else if (command.equals("update")) {
			am.update();
			
		} 
		else if (command.equals("delete")) {
			am.delete();
			
		} 
		else if(command.equals("search")) {
			am.search(pagination);
			
		}
		else if(command.equals("read")) {
			if(isLogin()) {
				am.printArticleDetail();						
			}
		}
		else if(command.equals("sort")) {
			am.sort(pagination);
		}
		else if(command.equals("page")) {
			am.page(pagination);
		}
	}
}
