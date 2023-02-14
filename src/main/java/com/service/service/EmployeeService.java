package com.service.service;

import java.util.List;
import com.service.entities.Employee;
import com.service.entities.Personne;

public interface EmployeeService {
	List < Employee > getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
     //void saveEmployee(Employee emp , Personne per);

}
