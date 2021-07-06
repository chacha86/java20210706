package example.exception;

public class ExceptionTest {

	public int test(int num) throws NegativeException {
		
		// 음수 X, 100 초과X -> 0 ~ 100 까지만 출력
		
		// 예외 처리 - 컴파일 예외, 런타임 예외
		if(num < 0) {
			throw new NegativeException(); // 1이면 음수				 
		}
		
//		if(num > 100) {
//			throw new HundredOverException(); // 2면 100 이상
//		}
		
		System.out.println(num);
		
		return 0; // 0은 문제 없음.
		
		
	}
	
}
