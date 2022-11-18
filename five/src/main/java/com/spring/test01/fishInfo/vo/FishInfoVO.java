package com.spring.test01.fishInfo.vo;

import org.springframework.stereotype.Component;

@Component("fishInfoVO")
public class FishInfoVO {

	private String fishImage;
	private String fishName;
	private String fishExplanation;
	private String fishLocation;
	private String fishTime;
	private String fishWeather;
	private int fishNum;
	
	public FishInfoVO() {
		// TODO Auto-generated constructor stub
	}

	public String getFishImage() {
		return fishImage;
	}

	public void setFishImage(String fishImage) {
		this.fishImage = fishImage;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public String getFishExplanation() {
		return fishExplanation;
	}

	public void setFishExplanation(String fishExplanation) {
		this.fishExplanation = fishExplanation;
	}

	public String getFishLocation() {
		return fishLocation;
	}

	public void setFishLocation(String fishLocation) {
		this.fishLocation = fishLocation;
	}

	public String getFishTime() {
		return fishTime;
	}

	public void setFishTime(String fishTime) {
		this.fishTime = fishTime;
	}

	public String getFishWeather() {
		return fishWeather;
	}

	public void setFishWeather(String fishWeather) {
		this.fishWeather = fishWeather;
	}

	public int getFishNum() {
		return fishNum;
	}

	public void setFishNum(int fishNum) {
		this.fishNum = fishNum;
	}

	public FishInfoVO(String fishImage, String fishName, String fishExplanation, String fishLocation, String fishTime,
			String fishWeather, int fishNum) {
		
		this.fishImage = fishImage;
		this.fishName = fishName;
		this.fishExplanation = fishExplanation;
		this.fishLocation = fishLocation;
		this.fishTime = fishTime;
		this.fishWeather = fishWeather;
		this.fishNum = fishNum;
	}
	
	
}
