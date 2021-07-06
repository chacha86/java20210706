package example.exception;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("==== 2번 프로그램 ====");
		ExceptionTest et = new ExceptionTest();
		
		int rst = et.test(-100);
		
		if(rst == 1) {
			System.out.println("음수는 아니되옵니다.");
		}
		
		
	}

}
