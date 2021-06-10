package coom.model;

public class Tester {

	public static void main(String[] args) {

		Vehicle myVehicle=new Truck();
		System.out.println(myVehicle.calcTripDistance(100.9, 900.8));
		System.out.println(myVehicle.calcFuelEfficiency(45));
		System.out.println(myVehicle.getDetails());
		myVehicle=new RiverBarge();
		System.out.println(myVehicle.calcTripDistance(90, 890.89));
		System.out.println(myVehicle.calcFuelEfficiency(1000));
		System.out.println(myVehicle.getDetails());
		myVehicle.setMessage("I Am On Riverbarge");
		System.out.println(myVehicle.getMessage());

	}

}