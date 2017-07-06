package com.techelevator.npgeek;

import java.util.List;

public class Weather {
	
	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private List<String> advisories;
	
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

//	public void setAdvisories(){
//		
//		String tempAdvisory = calculateTemperatureAdvisories();
//		String forecastAdvisory = calculateForecastAdvisories();
//		
//		if(!(tempAdvisory.isEmpty() && tempAdvisory.equals(null)) && !(forecastAdvisory.isEmpty() && forecastAdvisory.equals(null))){
//			advisories.add(forecastAdvisory);
//			advisories.add(tempAdvisory);
//		} else if (!(tempAdvisory.isEmpty() && tempAdvisory.equals(null))) {
//			advisories.add(tempAdvisory);
//		} else if (!(forecastAdvisory.isEmpty() && forecastAdvisory.equals(null))) {
//			advisories.add(forecastAdvisory);
//		} 
//		
//	}
//	
//	public List<String> getAdvisories(){
//		return advisories;
//	}
//	
////	public String calculateTemperatureAdvisories(){
////		
////		String advisory = null;
////		
////		if(high > 75){
////			advisory = "Bring an extra gallon of water!";
////		} else if ((high - low) > 20) {
////			advisory = "Wear breathable layers!";
////		} else if (low < 20) {
////			advisory = "Don't expose yourself to frigid temperatures!";
////		} 
////		
////		return advisory;
////	}
//	
//	public String calculateForecastAdvisories(){
//		
//		String advisory = null;
//		
//		if(forecast.equals("snow")){
//			advisory = "Pack snowshoes!";
//		} else if (forecast.equals("rain")) {
//			advisory = "Pack rain gear and wear waterproof shoes!";
//		} else if (forecast.equals("thunderstorms")) {
//			advisory = "Seek shelter and avoid hiking on exposed ridges!";
//		} else if (forecast.equals("sunny")) {
//			advisory = "Pack sunblock!";
//		} 
//		
//		return advisory;
//	}
	
}
