package com.techelevator.npgeek;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("isFahrenheit")
public class HomeController {

	@Autowired
	private ParkDao parkDao;
	@Autowired
	private WeatherDao weatherDao;
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		
		request.setAttribute("parks", parks);
		return "homePage";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.GET)
	public String displayParkDetails(@RequestParam(required=false) String parkCode, @ModelAttribute("parkCode") String parkCodeAttr, HttpServletRequest request, ModelMap map){
		if(parkCode == null) {
			parkCode = parkCodeAttr;
		}
		
		Park park = parkDao.getParkByParkCode(parkCode);
		List<Weather> forecast = weatherDao.getForecastByParkCode(parkCode);
		request.setAttribute("park", park);
		request.setAttribute("forecast", forecast);
		
	
		if(!map.containsAttribute("isFahrenheit")) {
			map.addAttribute("isFahrenheit", true);
		}
		
		return "parkDetails";
	}
	
	@RequestMapping(path="/parkDetails", method=RequestMethod.POST)
	public String setTempType(@RequestParam boolean isFahrenheit, @RequestParam String parkCode, RedirectAttributes redirectAttrs, ModelMap map){
		
		redirectAttrs.addFlashAttribute("parkCode", parkCode);
		map.addAttribute("isFahrenheit", isFahrenheit);
		return "redirect:/parkDetails";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String displaySurveyInput(HttpServletRequest request) {
		List<Park> parks = parkDao.getAllParks();
		
		request.setAttribute("parks", parks);
		
		return "surveyInput";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String saveSurvey(@RequestParam String parkName, @RequestParam String emailAddress, @RequestParam String state, @RequestParam String activityLevel) {
		Survey survey = new Survey();
		String parkCode = parkDao.getParkByParkName(parkName).getParkCode();
		
		survey.setParkCode(parkCode);
		survey.setEmailAddress(emailAddress);
		survey.setActivityLevel(activityLevel);
		survey.setState(state);
		
		surveyDao.save(survey);
		
		return "redirect:/surveyResults";
	}
	
	@RequestMapping("/surveyResults")
	public String showSurveyResults(HttpServletRequest request) {
		
		List<Park> topParks = parkDao.getTopParks();
		request.setAttribute("topParks", topParks);
		
		return "surveyResults";
	}
	
	
}
