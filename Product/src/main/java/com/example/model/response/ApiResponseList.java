package com.example.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiResponseList <T>{
    private String message;
    private T payload;
    private int totalRecords;
    private HttpStatus status;
    private LocalDateTime time;
}
