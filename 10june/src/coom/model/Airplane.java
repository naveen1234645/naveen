package coom.model;

public abstract class Airplane extends Vehicle {
	private double startPoint;
	private double endPoint;
	private double distanceCovered;
	private double fuelEfficiency;

	@Override
	public double calcFuelEfficiency(double fuelConsumed) {


		fuelEfficiency = distanceCovered / fuelConsumed;
		return fuelEfficiency;
	}

	@Override
	public double calcTripDistance(double startPoint, double endPoint) {

		this.startPoint = startPoint;
		this.endPoint = endPoint;
		distanceCovered = this.endPoint - this.startPoint;
		return distanceCovered;
	}

	@Override
	public String getDetails() {

		return super.getDetails() + " RiverBarge-->";
	}

	@Override
	public String getMessage() {

		return super.getMessage();
	}

	@Override
	public void setMessage(String message) {

		super.setMessage(message);
	}

	public abstract void takeOff();

	public abstract void land();

	public abstract void fly();

}
