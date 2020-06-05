package com.accolite.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.spring.entity.Logging;

public interface LoggingRepository extends JpaRepository<Logging, Long> {

}
