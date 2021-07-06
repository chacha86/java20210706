package example.board.article;

public class Pagination {
	
	private int currentPageNo = 1; // 현재페이지
	private int itemCountPerPage = 3;
	private int pageCountPerBlock = 5; // 한블럭당 페이지 다섯개
	private int totalCount; // 총 게시물 수
	
	public Pagination(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getItemCountPerPage() {
		return itemCountPerPage;
	}
	public void setItemCountPerPage(int itemCountPerPage) {
		this.itemCountPerPage = itemCountPerPage;
	}
	public int getStartIdx() {
		return itemCountPerPage * (currentPageNo - 1);
	}
	
	public int getEndIdx() {
		
		int rst = getStartIdx() + itemCountPerPage;
		
		// 마지막 인덱스를 넘지 않아야 한다.
		if(rst >= totalCount) {
			rst = totalCount;
		}
		
		return rst;
	}
	
	public int getPageCountPerBlock() {
		return pageCountPerBlock;
	}
	public void setPageCountPerBlock(int pageCountPerBlock) {
		this.pageCountPerBlock = pageCountPerBlock;
	}
	public int getCurrentPageBlock() {
		return (int)Math.ceil((double) currentPageNo / pageCountPerBlock);
	}
	public int getStartPageNo() {
		return (pageCountPerBlock * (getCurrentPageBlock() - 1)) + 1;
	}
	public int getEndPageNo() {
		int endPageNo = getStartPageNo() + (pageCountPerBlock - 1);
		if(endPageNo >= getLastPageNo()) {
			endPageNo = getLastPageNo();
		}
		return endPageNo;
	}
	
	public int getLastPageNo() {
		return (int)Math.ceil((double)totalCount / itemCountPerPage);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}

