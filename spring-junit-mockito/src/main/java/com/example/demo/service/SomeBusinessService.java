package com.example.demo.service;

public class SomeBusinessService {

	private SomeDataService someData;

	public SomeBusinessService(SomeDataService someData) {
		super();
		this.someData = someData;
	}

	public int calculateSum() {
		int[] arr = someData.retrieveData();
		int sum = 0;
		for (int value : arr){
			sum += value;
		}
		return sum;
	}
}