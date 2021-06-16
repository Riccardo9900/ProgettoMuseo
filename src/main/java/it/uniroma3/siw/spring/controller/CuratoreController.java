package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CuratoreValidator;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CuratoreController {

	@Autowired
	private CuratoreService curatoreService;

	@Autowired
	private CuratoreValidator curatoreValidator;

	@Autowired
	private CollezioneService collezioneService;

	@RequestMapping(value = "/collezione/edit/curatore/{id}", method = RequestMethod.GET) 
	public String showCuratoreForm(@PathVariable("id") Long id, Model model) {
		Curatore curatore = this.collezioneService.collezionePerId(id).getCuratore();
		model.addAttribute("curatore", curatore);
		return "curatoreForm.html";
	}
	
	@RequestMapping(value = "/collezioni", method = RequestMethod.POST) 
	public String changeCuratore(@ModelAttribute("curatore") Curatore curatore,	Model model, BindingResult bindingResult) {
		this.curatoreValidator.validate(curatore, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.curatoreService.inserisci(curatore);
			model.addAttribute("collezioni", this.collezioneService.tutteLeCollezioni());
			return "collezioni.html";
		}
		return "curatoreForm.html";
	}
}
