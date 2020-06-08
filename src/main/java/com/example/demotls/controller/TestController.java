package com.example.demotls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/restapi/normal")
    public ResponseEntity<?> testCall(@RequestBody Map<String, Object> requestBody){
        String url = (String) requestBody.get("path");
        String method = (String) requestBody.get("method");
        Object body = requestBody.get("body");
        return restTemplate.exchange(
                url,
                HttpMethod.valueOf(method),
                new HttpEntity<>(body, new HttpHeaders()),
                String.class
        );
    }

}
