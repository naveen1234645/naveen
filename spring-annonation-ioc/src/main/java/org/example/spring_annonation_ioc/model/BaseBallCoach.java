package org.example.spring_annonation_ioc.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

	private FortuneService happyFortuneService;
	
	@Autowired
	public BaseBallCoach(FortuneService happyFortuneService) {
		super();
		this.happyFortuneService = happyFortuneService;
	}

	@Override
	public String getDailyworkOut() {
		// TODO Auto-generated method stub
		return "practice back volley today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return happyFortuneService.getDailyFortune();
	}

}