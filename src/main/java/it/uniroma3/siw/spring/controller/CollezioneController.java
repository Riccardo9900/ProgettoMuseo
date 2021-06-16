package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CollezioneValidator;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService collezioneService;
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private CollezioneValidator collezioneValidator;
	
	@RequestMapping(value="/collezione", method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni", this.collezioneService.tutteLeCollezioni());
		return "collezioni.html";
	}
	
	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.GET)	
	public String getCollezione(@PathVariable("id") Long id, Model model) {
		Collezione collezione = this.collezioneService.collezionePerId(id);
		model.addAttribute("collezione", collezione);
		model.addAttribute("opere", collezione.getOpere());
		model.addAttribute("curatore", collezione.getCuratore());
		return "collezione.html";
	}
	
	@RequestMapping(value="/collezione/edit/{id}", method = RequestMethod.GET)
	public String showCollezioneForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("collezione", this.collezioneService.collezionePerId(id));
		return "collezioneForm.html";
	}
	
	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.POST) 
	public String changeCollezione(@ModelAttribute("collezione") Collezione collezione, Model model, BindingResult bindingResult) {
		this.collezioneValidator.validate(collezione, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.collezioneService.inserisci(collezione);
			model.addAttribute("opere", this.operaService.operePerCollezione(collezione));
			return "collezione.html";
		}
		return "collezioneForm.html";
	}
}
