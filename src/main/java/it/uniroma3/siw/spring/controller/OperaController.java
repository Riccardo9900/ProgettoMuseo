package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {

	@Autowired
	private OperaService operaService;

	@Autowired
	private OperaValidator operaValidator;

	@RequestMapping(value = "/opera/{id}", method = RequestMethod.GET)
	public String getOpera(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera", this.operaService.findById(id));
		return "opera.html";
	}

	@RequestMapping(value="/opera/edit/{id}", method = RequestMethod.GET)
	public String showOperaForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera", this.operaService.findById(id));
		return "operaForm.html";
	}
	
	@RequestMapping(value = "/opera/{id}", method = RequestMethod.POST) 
	public String changeOpera(@ModelAttribute("opera") Opera opera, Model model, BindingResult bindingResult) {
		this.operaValidator.validate(opera, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.operaService.inserisci(opera);
			return "opera.html";
		}
		return "operaForm.html";
	}
}

