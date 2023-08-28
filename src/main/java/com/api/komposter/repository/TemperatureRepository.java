package com.api.komposter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.komposter.entity.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, String>{

}
