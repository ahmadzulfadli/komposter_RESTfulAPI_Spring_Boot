package com.api.komposter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.komposter.entity.Moisture;

@Repository
public interface MoistureRepository extends JpaRepository<Moisture, String>{

}
