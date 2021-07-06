package example.Inheritance;

public abstract class Car {
	
	private int maxVelo;
	private String model;
	private int year;
	private int price;
	
	public abstract void accel();
	public abstract void stop(); 

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
