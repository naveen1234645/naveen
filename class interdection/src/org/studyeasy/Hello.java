package org.studyeasy;

public class Hello {
	
	public static void main(String[] args ) {
		Car car = new Car();
		car.setDoors("close");
		
		
		car.setDriver("Naveen");
		
		car.setEngine("Bs4");
		
		car.setSpeed(89);
		System.out.println(car.run());
	}
	
}
