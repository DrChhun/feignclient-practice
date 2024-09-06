package com.example.model.response;

import com.example.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class GetResponse {
    public static ResponseEntity<?> responseCreate(String message, Object payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseCreate.builder()
                .message(message)
                .payload(payload)
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build());
    }

    public static ResponseEntity<?> responseList(String message, Object payload, int totalRecords) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseList.builder()
                .message(message)
                .payload(payload)
                .totalRecords(totalRecords)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    public static ResponseEntity<?> responseObject(String message, int id, Object payload) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseObject.builder()
                .message(message + id)
                .payload(payload)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }

    public static ResponseEntity<?> responseDelete(String message, int id) {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDelete.builder()
                .message(message + id)
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build());
    }
}
