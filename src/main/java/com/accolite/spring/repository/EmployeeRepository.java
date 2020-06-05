package com.accolite.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.spring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
