package be.vdab.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	private static final String OPALFABET_VIEW = "brouwers/opalfabet";
	private static final String OPNAAM_VIEW = "brouwers/opnaam";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/brouwers";
	private final BrouwerService brouwerService;

	public BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
	}

	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(TOEVOEGEN_VIEW).addObject(new Brouwer());
	}

	@GetMapping("opalfabet")
	String searchByLetter() {
		return OPALFABET_VIEW;
	}

	@GetMapping("opnaam")
	ModelAndView findByNaam() {
		return new ModelAndView(OPNAAM_VIEW).addObject(new Naam());
	}

	@GetMapping("opalfabet/{letter}")
	ModelAndView readLetter(@PathVariable String letter) {
		return new ModelAndView(OPALFABET_VIEW, "brouwers", brouwerService.findByLetter(letter));
	}

	@GetMapping(params = "name")
	ModelAndView readNaam(@Valid Naam naam, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(OPNAAM_VIEW);
		if (!bindingResult.hasErrors()) {
			List<Brouwer> brouwers = brouwerService.findByNaam(naam);
			if (brouwers.isEmpty()) {
				bindingResult.reject("geenBrouwers");
			} else {
				modelAndView.addObject("brouwers", brouwers);
			}
		}
		return modelAndView;
	}

	@PostMapping
	String create(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
}
