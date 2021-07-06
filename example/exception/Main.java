package example.exception;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("==== 1번 프로그램 ====");
		ExceptionTest et = new ExceptionTest();
		
//		try {
//			int rst = et.test(-1000);						
//		} catch(NegativeException e) {
//			System.out.println("음수 예외 처리");
//			e.printMessage();
//		}
		int num = 0;
		System.out.println("작업1");
		if(num == 0) {
			try {
				throw new HundredOverException();							
			} catch(HundredOverException e) {
				System.out.println("백초과 예외 처리");
			}
		}
		
		System.out.println("작업2");
	
		
	}

}
