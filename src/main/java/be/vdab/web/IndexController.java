package be.vdab.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
	private static final String VIEW = "index";

	@GetMapping
	ModelAndView index() {
		return new ModelAndView(VIEW, "moment", getMoment());
	}

	private String getMoment() {
		LocalDateTime now = LocalDateTime.now();
		int hours = now.getHour();
		if (hours >= 0 && hours < 6) {
			return "nacht";
		} else if (hours >= 6 && hours < 12) {
			return "morgen";
		} else if (hours >= 12 && hours < 18) {
			return "middag";
		} else{
			return "avond";
		}
	}
}
