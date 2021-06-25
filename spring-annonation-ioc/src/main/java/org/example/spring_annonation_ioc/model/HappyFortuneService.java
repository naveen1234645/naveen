package org.example.spring_annonation_ioc.model;


import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "today is your lucky day";
	}

}