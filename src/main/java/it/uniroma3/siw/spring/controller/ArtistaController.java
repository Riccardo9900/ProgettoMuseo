package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ArtistaValidator;
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class ArtistaController {

	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private ArtistaValidator artistaValidator;
	
	@Autowired
	private OperaService operaService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/artista/{id}", method = RequestMethod.GET)	
	public String getArtista(@PathVariable("id") Long id, Model model) {
		logger.debug("getArtista");
		Artista artista = this.artistaService.artistaPerId(id);
		model.addAttribute("artista", artista);
		model.addAttribute("opere", artista.getOpere());
		return "artista.html";
	}

	@RequestMapping(value = "/artista", method = RequestMethod.GET)
	public String getTuttiGliArtisti(Model model) {
		logger.debug("getTuttiGliArtisti");
		model.addAttribute("artisti", this.artistaService.tuttiGliArtisti());
		return "artisti.html";
	}
	
	@RequestMapping(value="/artista/edit/{id}", method = RequestMethod.GET)
	public String showOperaForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("artista", this.artistaService.artistaPerId(id));
		return "artistaForm.html";
	}
	
	@RequestMapping(value = "/artista/{id}", method = RequestMethod.POST) 
	public String changeArtista(@ModelAttribute("artista") Artista artista, Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.artistaService.inserisci(artista);
			model.addAttribute("opere", this.operaService.operePerArtista(artista));
			return "artista.html";
		}
		return "artistaForm.html";
	}
}
