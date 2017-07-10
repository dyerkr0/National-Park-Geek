package com.techelevator.npgeek;

import java.util.List;

public interface ParkDao {

	public List<Park> getAllParks();
	public Park getParkByParkCode(String parkCode);
	public Park getParkByParkName(String parkName);
	public List<Park> getTopParks();
		
}
