package coom.model;

public class SuperMan extends Airplane implements Sailer{

	public void dock() {
		System.out.println("Allow Superman To Dock in the harbour");

	}

	@Override
	public void takeOff() {

		System.out.println("Superman takeoff");
	}

	@Override
	public void land() {
		System.out.println("Superman Landed.");

	}

	@Override
	public void fly() {

		System.out.println("Superman Flying.");
	}

	@Override
	public double calcTripDistance(double startPoint, double endPoint) {

		return super.calcTripDistance(startPoint, endPoint);
	}



}