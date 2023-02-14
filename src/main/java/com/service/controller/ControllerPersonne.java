package com.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.entities.Personne;
import com.service.repository.PersonneRepository;

@Controller
public class ControllerPersonne {
	
	@Autowired
	private PersonneRepository personnerepository;
	@GetMapping("/personne")
    public String viewHomePage(Model model) {
        model.addAttribute("listPersonne", personnerepository.findAll());
        return "viewpersonne";
    }
	
	@PostMapping("/SavePersonne")

    public String save(@ModelAttribute Personne personne){
        ModelAndView model = new ModelAndView();
        model.setViewName("personne");
        model.addObject("personne",personne);
        this.personnerepository.save(personne);
        return  "redirect:/";
    }
	
	@GetMapping("/showNewPersonneForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Personne personne= new Personne();
        model.addAttribute("personne", personne);
        return "new_personne";
    }
	
	@GetMapping("/deletePersonne/{id}")
    public String deletePersonne(@PathVariable(value = "id") long id) {
    	this.personnerepository.deleteById(id);
        // call delete employee method 
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewpersonne");
        return "redirect:/personne";
    }
}
