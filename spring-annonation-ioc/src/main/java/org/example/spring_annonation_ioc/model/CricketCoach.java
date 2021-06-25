package org.example.spring_annonation_ioc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	private FortuneService happyFortuneService;

	@Value("${coach.team}")
	private String team;

@Autowired
public CricketCoach(FortuneService happyFortuneService) {
		super();
		this.happyFortuneService = happyFortuneService;
	}


	@Override
	public String getDailyworkOut() {
		// TODO Auto-generated method stub
		return "practice batting today"+team;
	}



	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return happyFortuneService.getDailyFortune();
	}

}
