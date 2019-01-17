package me.mkgl.demo;

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
        private String id;
        private String url;
    }
}