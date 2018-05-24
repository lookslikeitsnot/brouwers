package be.vdab.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.valueobjects.Naam;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String OPALFABET_VIEW = "brouwers/opalfabet";
	private static final String OPNAAM_VIEW = "brouwers/opnaam";
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

	@GetMapping("opnaam")
	ModelAndView findByPostcodeReeks() {
		Naam naam = new Naam();
		return new ModelAndView(OPNAAM_VIEW).addObject(naam);
	}

	@GetMapping("opalfabet/{letter}")
	ModelAndView readLetter(@PathVariable String letter) {
		return new ModelAndView(OPALFABET_VIEW, "brouwers", brouwerService.findByLetter(letter));
	}

	@GetMapping(params = "name")
	ModelAndView readNaam(@Valid Naam name, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(OPNAAM_VIEW);
		if (!bindingResult.hasErrors()) {
			List<Brouwer> brouwers = brouwerService.findByNaam(name);
			if (brouwers.isEmpty()) {
				bindingResult.reject("geenBrouwers");
			} else {
				modelAndView.addObject("brouwers", brouwers);
			}
		}
		return modelAndView;
	}
}
