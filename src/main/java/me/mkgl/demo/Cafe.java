package me.mkgl.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Cafe {
    private String name;
    private String address;
    private String description;
    private long evaluation;

    private String website;
    private String location;
    private Photo photo;

    @Data
    public static class Photo {
        @JsonProperty("@id")
        private String id;
        @JsonProperty("@link")
        private String url;

        public String getUrl() {
            return CafeService.HOST + url;
        }
    }
}