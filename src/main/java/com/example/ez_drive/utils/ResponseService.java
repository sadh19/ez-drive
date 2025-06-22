package com.example.ez_drive.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResponseService {

    public <T> ResponseEntity<Map<String, Object>> generateResponse(String message, T data) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("response", data);
        return ResponseEntity.ok(result);
    }

}
