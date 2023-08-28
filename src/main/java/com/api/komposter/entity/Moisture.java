package com.api.komposter.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "moistures")
@Entity
public class Moisture {
    
    @Id
    private String id;

    private String value;

    private LocalDateTime timestamp;
}
