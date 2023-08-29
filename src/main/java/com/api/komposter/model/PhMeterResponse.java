package com.api.komposter.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhMeterResponse {
    
    private String id;

    private String value;

    private LocalDateTime timestamp;
}
