package com.accolite.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.spring.entity.Demand;

public interface DemandRepository extends JpaRepository<Demand,Long> {

}
