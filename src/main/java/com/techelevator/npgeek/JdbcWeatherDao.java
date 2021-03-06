package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getForecastByParkCode(String parkCode){
		List<Weather> forecast = new ArrayList<Weather>();
		
		String sqlGetForecastByParkCode = "SELECT * FROM weather WHERE parkCode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetForecastByParkCode, parkCode);
		
		while(results.next()){
			Weather weather = mapRowToWeather(results);
			forecast.add(weather);
		}
		
		return forecast;
		
	}
	
	private Weather mapRowToWeather(SqlRowSet results){
		Weather weather = new Weather();
		
		weather.setParkCode(results.getString("parkCode"));
		weather.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		//weather.setAdvisories();
		
		return weather;
	}
}
