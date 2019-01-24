package me.mkgl.demo;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import lombok.Data;

public class CafeService {
    static final String HOST = "http://localhost:8580";
    static final String BASE_URI = HOST + "/.rest/delivery/cafes/v1";

    List<Cafe> getAllCafes() {
        RestTemplate restTemplate = new RestTemplate();
        CafeListResponse response = restTemplate.getForObject(BASE_URI, CafeListResponse.class);
        return response.getResults();
    }

    Cafe getCafe(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(BASE_URI + "/{id}", Cafe.class, id);
    }

    @Data
    private static class CafeListResponse {
        private List<Cafe> results;
    }
}
