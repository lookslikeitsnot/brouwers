package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String OPALFABET_VIEW = "brouwers/opalfabet";
	private final BrouwerService brouwerService;

	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}

	@GetMapping("toevoegen")
	String createForm() {
		return TOEVOEGEN_VIEW;
	}
	
	@GetMapping("beginnaam")
	String searchNaam() {
		return BEGINNAAM_VIEW;
	}
	
	@GetMapping("opalfabet")
	String searchByLetter() {
		return OPALFABET_VIEW;
	}
	
	@GetMapping("{letter}")
	ModelAndView read(@PathVariable String letter) {
		return new ModelAndView(OPALFABET_VIEW, "brouwers", brouwerService.findByLetter(letter));
	}
}
