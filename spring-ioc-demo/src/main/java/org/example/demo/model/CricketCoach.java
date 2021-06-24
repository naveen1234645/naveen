package org.example.demo.model;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;



	/*
	 * public FortuneService getFortuneService() { return fortuneService; }
	 */

	//setter injection
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyworkOut() {
		// TODO Auto-generated method stub
		return "practice batting today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}