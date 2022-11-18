package com.spring.test01.common.random;

public class RandomGuestBookColor {

	public String randomGuestBookColor(int randomNumber) throws Exception{
		
		String classColor = "";
		
		if(randomNumber == 0) {
			classColor = "card text-white bg-primary mb-3";
		}else if(randomNumber == 1) {
			classColor = "card text-white bg-secondary mb-3";
		}else if(randomNumber == 2) {
			classColor = "card text-white bg-success mb-3";
		}else if(randomNumber == 3) {
			classColor = "card text-white bg-danger mb-3";
		}else if(randomNumber == 4) {
			classColor = "card text-white bg-warning mb-3";
		}else if(randomNumber == 5) {
			classColor = "card text-white bg-info mb-3";
		}else if(randomNumber == 6) {
			classColor = "card bg-light mb-3";
		}else if(randomNumber == 7) {
			classColor = "card text-white bg-dark mb-3";
		}
		
		return classColor;
		
	}
	
}
