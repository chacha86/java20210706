package example.exception;

public class NegativeException extends Exception{
	public void printMessage() {
		System.out.println("음수 예외");
	}
}
