package com.accolite.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.spring.entity.Logging;
import com.accolite.spring.repository.LoggingRepository;

@Service
public class LoggingService {

	@Autowired
	private LoggingRepository repository;

	public Logging save(Logging logging) {
		return repository.save(logging);
	}

	public List<Logging> list() {
		return repository.findAll();
	}

}
