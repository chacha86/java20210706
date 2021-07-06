package example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
	
	public static void main(String[] args) {
		
		int[] arr = {2,3,5,1,4};
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		// 정렬의 목적 : 탐색, 검색
		numList.add(3); // 3
		numList.add(1); // 1
		numList.add(5); // 5
		numList.add(4); // 4
		numList.add(2); // 2
		
		// 오름차순
		Collections.sort(numList);
		
		// 내림차순
		Collections.sort(numList, Collections.reverseOrder());
		
		for(int i = 0; i < numList.size(); i++) {
			System.out.print(numList.get(i) + " ");
		}
		
		ArrayList<String> strList = new ArrayList<String>();
		
		strList.add("grape");
		strList.add("apple");
		strList.add("orange");
		strList.add("banana");
		
		Collections.sort(strList);
		Collections.sort(strList, Collections.reverseOrder());
		
		for(int i = 0; i < strList.size(); i++) {
			System.out.print(strList.get(i) + " ");
		}
		
		ArrayList<Person> pList = new ArrayList<Person>();
		
		pList.add(new Person(20, "홍길동"));
		pList.add(new Person(23, "이순신"));
		pList.add(new Person(17, "황진이"));
		pList.add(new Person(30, "임꺽정"));

		PersonSorter ps = new PersonSorter();
		
		Collections.sort(pList, ps);
		
		for( int i = 0; i < pList.size(); i++ ) {
			pList.get(i).introduce();
			System.out.println("======================");
		}
		
		
	}
}

class PersonSorter implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		
		if ( p1.name.compareTo(p2.name) > 0) {
		      return 1; // 1 리턴 -> 두 객체의 자리를 바꾼다
	    }
		
		return -1;
	}
	
}


