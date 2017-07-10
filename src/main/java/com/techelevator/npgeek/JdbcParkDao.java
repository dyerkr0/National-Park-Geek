package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks(){
		List<Park> parks = new ArrayList<Park>();
		String sqlSelectAllParks = "SELECT * FROM park ORDER BY parkName";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			parks.add(mapRowToPark(results));
		}
		return parks;
	}

	@Override
	public Park getParkByParkCode(String parkCode) {
		Park park = null;
		String sqlGetParkByParkCode = "SELECT * FROM park WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByParkCode, parkCode);
		if(results.next()) {
			park = mapRowToPark(results);
		}
		
		return park;
	}
	
	@Override
	public Park getParkByParkName(String parkName) {
		Park park = null;
		String sqlGetParkByParkCode = "SELECT * FROM park WHERE parkName = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByParkCode, parkName);
		if(results.next()) {
			park = mapRowToPark(results);
		}
		
		return park;
	}

	@Override
	public List<Park> getTopParks() {
		List<Park> topParks = new ArrayList<Park>();
		
		String sqlGetTopSurveys =  "SELECT survey_result.parkcode, park.*, COUNT(survey_result.parkcode) as count FROM survey_result " +
								   "JOIN park ON park.parkCode = survey_result.parkcode " +
								   "GROUP BY survey_result.parkcode, park.parkCode " +
								   "ORDER BY count desc, survey_result.parkcode "+
								   "LIMIT 5";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetTopSurveys);
		while(results.next()){
			Park park = mapRowToPark(results);
			park.setCount(results.getInt("count"));
			topParks.add(park);
		}
		
		return topParks;
	}

	
	private Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();
		
		park.setParkCode(results.getString("parkCode"));
		park.setParkName(results.getString("parkName"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationInFeet"));
		park.setMilesOfTrail(results.getFloat("milesOfTrail"));
		park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearFounded"));
		park.setAnnualVisitorCount(results.getInt("annualVisitorCount"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
		park.setParkDescription(results.getString("parkDescription"));
		park.setEntryFee(results.getInt("entryFee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		park.setImageName();
		
		return park;
	}


}
