package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("tempType")
public class HomeController {

	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		
		request.setAttribute("parks", parks);
		return "homePage";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String displayParkDetails(@RequestParam String parkCode, ModelMap map){
		Park park = parkDao.getParkByParkCode(parkCode);
		List<Weather> forecast = weatherDao.getForecastByParkCode(parkCode);
		map.put("park", park);
		map.put("forecast", forecast);
		
		return "parkDetails";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.POST)
	public String setTempType(@RequestParam String tempType, ModelMap map){
		
		return "redirect:/parkDetails";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String displaySurveyInput(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		
		request.setAttribute("parks", parks);
		
		return "surveyInput";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String showSurveyResults(HttpServletRequest request) {
		
		
		return "redirect:/surveyResults";
	}
	
	
}
