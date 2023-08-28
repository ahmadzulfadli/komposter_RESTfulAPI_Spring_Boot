package com.api.komposter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.komposter.entity.PhMeter;

@Repository
public interface PhMeterRepository extends JpaRepository<PhMeter, String>{
    
}
