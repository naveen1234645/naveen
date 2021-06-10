package coom.model;

public class SeaPlane extends Airplane implements Sailer {


	public void dock() {

		System.out.println("Permission granted for SeaPlane to Dock in the Harbour..");
	}

	@Override
	public void takeOff() {
		System.out.println("Seaplane Is Taking Off");

	}

	@Override
	public void land() {
		System.out.println("Seaplane Is Landed");

	}

	@Override
	public void fly() {
		System.out.println("Seaplane Is Flying.");

	}

	@Override
	public double calcFuelEfficiency(double fuelConsumed) {
		// TODO Auto-generated method stub
		return super.calcFuelEfficiency(fuelConsumed);
	}

	@Override
	public double calcTripDistance(double startPoint, double endPoint) {
		// TODO Auto-generated method stub
		return super.calcTripDistance(startPoint, endPoint);
	}

}

