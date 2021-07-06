package example.Inheritance;

public class Morning extends Car {
	
	private String model;
	
	public void accel() {
		System.out.println("모닝이 귀엽게 달립니다.");
	}
	
	public void stop() {
		System.out.println("모닝이 멈춥니다.");
	}
	
//	public void accel() {
//		System.out.println(model + "이/가 귀엽게 달립니다.!!");
//	}

	public void FuelEfficiency() {
		System.out.println("연비모드 ON");
	}
}
