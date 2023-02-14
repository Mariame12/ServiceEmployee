package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.entities.Employee;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Long> {

}
