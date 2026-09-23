package weatherapp.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController 
{
	@Autowired
	private WeatherService weatherservice;
	
	
	@GetMapping("/")
	public String display()
	{
		return "weather";
	}
	
	@GetMapping("weather")
	public String show_weather_details(@RequestParam String city, Model model)
	{
		WeatherResponse weatherresponse = weatherservice.getWeather(city);
		
		model.addAttribute("weather",weatherresponse);
		
		return "weather";
	}
	

}
