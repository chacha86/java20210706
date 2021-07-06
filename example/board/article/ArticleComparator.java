package example.board.article;

import java.util.Comparator;

public class ArticleComparator implements Comparator<Article> {

	private int sortType; // 1. 오름차순, 2. 내림차순
	private int sortTarget; // 1. 조회수, 2. 제목
	
	@Override
	public int compare(Article o1, Article o2) {
		int rst = 1; // 정렬 결과값
		
		if(sortType == 2) {
			rst *= -1;
		}
		
		if(sortTarget == 1) {
			if(o1.getHit() > o2.getHit()) {
				return rst;
			}			
		}
		else if(sortTarget == 2) {
			if(o1.getTitle().compareTo(o2.getTitle()) < 0) {
				return rst;
			}
		}
		
		return -1 * rst;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	public int getSortTarget() {
		return sortTarget;
	}

	public void setSortTarget(int sortTarget) {
		this.sortTarget = sortTarget;
	}
	
}
