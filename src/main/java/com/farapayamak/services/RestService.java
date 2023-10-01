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
import com.google.code.gson;

@Service
public class RestService {
    
    private final RestTemplate restTemplate;
    private final Gson gson;

    private String Username = "username";
    private String Password = "password";

    private final String Endpoint = "https://rest.payamak-panel.com/api/%s";
    
    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        gson = new Gson();
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
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
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
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
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
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
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
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetBasePrice() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetUserNumbers() {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse BaseServiceNumber(String text, String to, Integer bodyId) {
        String operation = new Object() {}.getClass().getEnclosingMethod().getName();
        String url = String.format(Endpoint, "SendSMS/" + operation);
        
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


    // SMART
    public RestResponse SendSmartSMS(String to, String text, String from, String fromSupportOne, String fromSupportTwo) {
        String url = String.format(Endpoint, "SmartSMS/Send");
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("text", text);
        map.put("to", to);
        map.put("from", from);
        map.put("fromSupportOne", fromSupportOne);
        map.put("fromSupportTwo", fromSupportTwo);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }


    public RestSmartResponse SendMultipleSmartSMS(String[] to, String[] text, String from, String fromSupportOne, String fromSupportTwo) {
        String url = String.format(Endpoint, "SmartSMS/SendMultiple");
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("text", text);
        map.put("to", gson.toJson(to));
        map.put("from", gson.toJson(from));
        map.put("fromSupportOne", fromSupportOne);
        map.put("fromSupportTwo", fromSupportTwo);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestSmartResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetSmartDeliveries2(Long id) {
        String url = String.format(Endpoint, "SmartSMS/GetDeliveries2");
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("Id", id);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }

    public RestResponse GetSmartDeliveries(Long[] ids) {
        String url = String.format(Endpoint, "SmartSMS/GetDeliveries");
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", this.Username);
        map.put("password", this.Password);
        map.put("Ids", gson.toJson(ids));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, GetHttpHeaders());
        
        ResponseEntity<RestResponse> response = this.restTemplate.postForEntity(url, entity, RestResponse.class);
        
        return response.getBody();
    }
}
