package com.techelevator.npgeek;

import java.text.DecimalFormat;

public class Temperature {
	
	private double degrees;
	
	public Temperature(double degrees){
		this.degrees = degrees;
	}
	
	public void convertTempToCelsius(Temperature degrees) {
		degrees = (degrees.subtract(32)).multiply(5.0/9.0);
	}
	
	public void convertTempToFahrenheit(Temperature degrees) {
		degrees = degrees.multiply((1.8) + 32);
	}

	 public Temperature multiply(double multiplier){
	    return new Temperature(degrees * multiplier);
	 }
	 
	 public Temperature subtract(double subtracter){
	    return new Temperature(degrees - subtracter);
	 }
	
	 
//	 @Override
//	 public int hashCode(){
//		 return (int)degrees;
//	 }
	 
	 @Override
	 public String toString(){
		 //DecimalFormat decimalFormat = new DecimalFormat("###.##");
		 return String.format("##.##", degrees);
	 }
	 
	 
}
