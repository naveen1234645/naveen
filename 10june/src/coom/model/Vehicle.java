package coom.model;

public abstract class Vehicle {

	public abstract double calcFuelEfficiency(double fuelConsumed);
	public abstract double calcTripDistance(double startPoint,double endPoint);

	private String message;
	public String getDetails()
	{
		return "hello";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}