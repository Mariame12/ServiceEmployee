package com.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.entities.Employee;

import com.service.repository.employeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private  employeeRepository employeerepository;
	//@Autowired
//	private PersonneRepository personnerepository;
	
	@Override
	public List<Employee> getAllEmployees()
	{
		return employeerepository.findAll();
	}
	

	@Override
	public void saveEmployee(Employee employee) {
		
		 this.employeerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional < Employee > optional = employeerepository.findById(id);
		//Optional < Personne > optional1 = personnerepository.findById(id);
       Employee employee = null;
       // Personne personne 
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employeerepository.deleteById(id);
		
	}
	
	/*public void saveEmployee(Employee empdetail, Personne per) {
	    try {
	    	
	        // Ajoutez des données dans la première table
	    	 personnerepository.save(per);
	    	 Employee emp = null; 
	    	 emp.setFonction(empdetail.getFonction());
	    	 emp.setPersonne(per);
	    	employeerepository.save(emp);
	        
	        // Ajoutez des données dans la seconde table
	       
	    } catch (Exception ex) {
	        // Gestion des erreurs ici
	    }
	}*/

	
	

}
