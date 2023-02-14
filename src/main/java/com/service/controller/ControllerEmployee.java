package com.service.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.entities.Employee;
import com.service.repository.PersonneRepository;
import com.service.entities.Personne;
import com.service.service.EmployeeService;

@Controller

public class ControllerEmployee {
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private PersonneRepository personnerepository;
	
	private static final Logger log=LoggerFactory.getLogger(ControllerEmployee.class);
	
	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeservice.getAllEmployees());
        return "index";
    }
	@GetMapping("/userList/{id}")
	public String viewId(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeservice.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "view";
		
	}

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Personne personne= new Personne();
    	model.addAttribute("personne", personne);
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        
  
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @ModelAttribute Personne personne) {
        // save employee to database
    	personnerepository.save(personne);
    	employee.setPersonne(personne);
        employeeservice.saveEmployee(employee);
       
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeservice.getEmployeeById(id);
        Optional<Personne> personne= personnerepository.findById(id);
        model.addAttribute("personne", personne);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, @ModelAttribute Employee employee) {
        ModelAndView model = new ModelAndView();
        
        model.setViewName("employee");
        employee.setId(id);
        //employee.setPersonne(personne);
        model.addObject("employee",employee);   
        employeeservice.saveEmployee(employee);
        log.info("employee {}", employee.getPersonne().getNom());
        
        return "redirect:/";
  }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeservice.deleteEmployeeById(id);
        return "redirect:/";
    }

}
