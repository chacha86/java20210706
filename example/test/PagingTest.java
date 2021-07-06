package example.test;

import java.util.ArrayList;
import java.util.Scanner;

public class PagingTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int currentPageNo = 1; // 현재페이지
		int itemCountPerPage = 3;
		int startIdx = itemCountPerPage * (currentPageNo - 1); // 현재 페이지에서 보여줄 첫 데이터 index
		int endIdx = startIdx + itemCountPerPage; // 현재 페이지에서 보여줄 마지막 데이터 index
		int pageCountPerBlock = 5; // 한블럭당 페이지 다섯개
		
		// 현재 페이지 1 ~ 5 : 1 블럭 -> 한페이지블럭당 페이지개수 / 현재페이지번호 => 0.XXX ~ 5/5 1
		// 현재 페이지 6 ~ 10 : 2 블럭 -> 한페이지블럭당 페이지개수 /  => 1.XXX ~ 2
		// 현재 페이지 11 ~ 15 : 3 블럭 ->
		// ...
		
				
		ArrayList<String> datas = new ArrayList<String>();
		datas.add("aaa");
		datas.add("bbb");
		datas.add("ccc");
		
		datas.add("ddd");
		datas.add("eee");
		datas.add("fff");
		
		datas.add("hhh");
		datas.add("iii");
		datas.add("jjj");

		
		int lastPageNo = (int)Math.ceil((double)datas.size() / itemCountPerPage); // 8 / 3 = 2.xX
		
		while(true) {
			System.out.println("currentPageNo : " + currentPageNo);
			int CurrentPageBlock = (int)Math.ceil((double) currentPageNo / pageCountPerBlock);
			startIdx = itemCountPerPage * (currentPageNo - 1);
			endIdx = startIdx + itemCountPerPage;
			
			// 마지막 인덱스가 실제 저장소의 인덱스를 넘어가는지 체크
			if(endIdx >= datas.size()) {
				endIdx = datas.size();
			}
			
			// 최대 페이지, 최소 페이지
			
			System.out.println("===========");
			for(int i = startIdx; i < endIdx; i++) {
				System.out.println(datas.get(i));
				System.out.println("===========");
				
			}
			
			int startPageNo = (pageCountPerBlock * (CurrentPageBlock - 1)) + 1;
			int endPageNo = startPageNo + (pageCountPerBlock - 1);
			
			if(endPageNo > lastPageNo) {
				endPageNo = lastPageNo;
			}
			
			for(int i = startPageNo; i <= endPageNo; i++) {
				if(i == currentPageNo) {
					System.out.print("[" + i + "] ");
				}
				else {
					System.out.print(i + " ");				
				}
			}
			
			System.out.println("페이지 기능 입력 (1. 이전, 2. 다음, 3. 선택) :");
			int pageCmd = Integer.parseInt(sc.nextLine());		
			
			if(pageCmd == 1) {
				currentPageNo--;
			}
			else if(pageCmd == 2) {
				currentPageNo++;
			}
			else if(pageCmd == 3) {
				System.out.println("몇번 페이지로 갈까요? :");
				int targetPage = Integer.parseInt(sc.nextLine());
				currentPageNo = targetPage; 
			}
			
		}

	}

}
