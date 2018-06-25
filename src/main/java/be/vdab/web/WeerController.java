package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.exceptions.KanWeerNietLezenException;
import be.vdab.services.WeerService;

@Controller
@RequestMapping("weer")
public class WeerController {
	private final static String VIEW = "weer";
	private final WeerService weerService;

	public WeerController(WeerService weerService) {
		this.weerService = weerService;
	}

	@GetMapping("{stad}/stadstemperatuur")
	ModelAndView naarDollar(@PathVariable String stad) {
		ModelAndView modelAndView = new ModelAndView(VIEW);
		try {
			modelAndView.addObject("temperatuur", weerService.stadsTemperatuur(stad));
		} catch (KanWeerNietLezenException ex) {
			modelAndView.addObject("fout", "Kan weer niet lezen");
		}
		return modelAndView;
	}
}
