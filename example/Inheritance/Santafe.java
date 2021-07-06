package example.Inheritance;

public class Santafe extends Car {
	
	private String model;
	
	public void accel() {
		System.out.println("싼타페가 힘차게 달립니다.");
	}
	
	public void stop() {
		System.out.println("싼타페가 멈춥니다.");
	}
	
//	public void accel() {
//		System.out.println(model + "이/가 힘차게 달립니다.!!");
//	}
	
	public void fourWheelDrive() {
		System.out.println("4륜 전환");
	}
}
