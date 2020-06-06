package com.accolite.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.spring.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
