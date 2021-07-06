package example.test;

public class CastingTest {

	public static void main(String[] args) {
		
		// (자료)형(Type) 변환
		
		int a = 10;
		String s = "aaa";
		
		//int b = "aa";
		
		// 같은 계열인 경우 형변환 가능
		
		// 정수 계열 - int(4) - 21억 , byte, short, long(8) - 900경
		// 형변환 규칙 
		// 1. 기본적으로 형이 안맞으면 안들어간다.
		// 2. 자바가 무조건 안해주는게 아니라 변환을 시도. 안전하다고 판단되면 알아서 변환해줌
		
		
		int c = 2100000000;// 21억
		long b = c; // int 값이 long으로 들어간 것이 아님!! int가 long으로 바뀌어서 들어간 것임. 자동 형변환
		
		long k = 2200000000L;
		
		System.out.println(k);
		
		int f = (int)k; // 형변환 시도 하다가 위험하다고 판단. 수동형변환 -> 개발자가 책임 져야함
		System.out.println(f);
		
		double d = f; // 정수, 실수 -> 수 계열
		
		int i = (int)d; //
		
//		
//		System.out.println(b);
	

		
				
		
		
		// 실수 계열 - float, double
		
		
		// 객체 - 무수히 많다.
		

	}

}
