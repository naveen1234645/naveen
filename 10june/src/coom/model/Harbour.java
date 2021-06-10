package coom.model;

public class Harbour {

	public static void main(String[] args) {
		Harbour bostonHarbour=new Harbour();
		RiverBarge riverBarge=new RiverBarge();
		System.out.println(riverBarge.calcTripDistance(100.0, 200.0));
		System.out.println(riverBarge.calcFuelEfficiency(400));
		bostonHarbour.givePermissionToDock(riverBarge);
		SeaPlane seaPlane=new SeaPlane();
		seaPlane.takeOff();
		seaPlane.fly();
		seaPlane.land();
		System.out.println(seaPlane.calcTripDistance(100, 1900));
		System.out.println(seaPlane.calcFuelEfficiency(900));
		bostonHarbour.givePermissionToDock(seaPlane);
		SuperMan superMan=new SuperMan();
		superMan.takeOff();
		superMan.fly();
		superMan.land();
		System.out.println(superMan.calcTripDistance(100, 900));
		bostonHarbour.givePermissionToDock(superMan);

	}


	private void givePermissionToDock(Sailer s)
	{
		s.dock();
	}



}