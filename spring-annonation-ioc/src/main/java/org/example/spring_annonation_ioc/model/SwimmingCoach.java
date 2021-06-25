package org.example.spring_annonation_ioc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

	private FortuneService sadFortuneService;

	// constructor injection

	@Override
	public String getDailyworkOut() {
		// TODO Auto-generated method stub
		return "practice back swimming today";
	}

	@Autowired
	public SwimmingCoach(FortuneService sadFortuneService) {
		super();
		this.sadFortuneService = sadFortuneService;
	}


	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return sadFortuneService.getDailyFortune();
	}

}