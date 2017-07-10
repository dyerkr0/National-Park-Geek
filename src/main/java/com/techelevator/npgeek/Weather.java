package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

public class Weather {
	
	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
//		this.low = new Temperature(low);
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
//		this.high = new Temperature(high);
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}


	public List<String> getAdvisories(){
		List<String> advisories = new ArrayList<String>();
		
		if(high > 75){
			advisories.add("Bring an extra gallon of water!");
		} 
		
		if ((high - low) > 20) {
			advisories.add("Wear breathable layers!");
		}
		
		if (low < 20) {
			advisories.add("Don't expose yourself to frigid temperatures!");
		} 

		if(forecast.equals("snow")){
			advisories.add("Pack snowshoes!");
		}
	
		if (forecast.equals("rain")) {
			advisories.add("Pack rain gear and wear waterproof shoes!");
		}  
		
		if (forecast.equals("thunderstorms")) {
			advisories.add("Seek shelter and avoid hiking on exposed ridges!");
		} 
		
		if (forecast.equals("sunny")) {
			advisories.add("Pack sunblock!");
		} 
		
		return advisories;
	}

}
