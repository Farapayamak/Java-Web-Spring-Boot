package com.farapayamak.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farapayamak.services.models.RestResponse;

@Service
public class RestService {
    
    private final RestTemplate restTemplate;

    private String Username = "username";
    private String Password = "password";

    private final String Endpoint = "https://rest.payamak-panel.com/api/SendSMS/%s";
    
    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private HttpHeaders GetHttpHeaders() {
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        // set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public RestResponse SendSMS(String to, String from, String text, Boolean isFlash) {
        
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("to", to);
        map.put("from", from);
        map.put("text", text);
        map.put("isFlash", isFlash);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetDeliveries2(Long recID) {

        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("recID", recID);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetMessages(Integer location, String from, Integer index, Integer count) {

        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("location", location);
        map.put("from", from);
        map.put("index", index);
        map.put("count", count);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetCredit() {

        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetBasePrice() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetUserNumbers() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse BaseServiceNumber(String text, String to, Integer bodyId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("text", text);
        map.put("to", to);
        map.put("bodyId", bodyId);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

}
