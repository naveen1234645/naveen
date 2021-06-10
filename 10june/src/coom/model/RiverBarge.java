package coom.model;

public class RiverBarge extends Vehicle implements Sailer{
	private double startPoint;
	private double endPoint;
	private double distanceCovered;
	private double fuelEfficiency;
	@Override
	public double calcFuelEfficiency(double fuelConsumed) {
		// TODO Auto-generated method stub
		
	fuelEfficiency= distanceCovered/fuelConsumed;
	return fuelEfficiency;
	}
	@Override
	public double calcTripDistance(double startPoint, double endPoint) {
		// TODO Auto-generated method stub
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		distanceCovered=this.endPoint-this.startPoint;
		return distanceCovered;
	}
	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return super.getDetails() +" RiverBarge-->";
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		super.setMessage(message);
	}

	public void dock() {
		System.out.println("Give RiverBarge Permission to Dock.");

	}

}

