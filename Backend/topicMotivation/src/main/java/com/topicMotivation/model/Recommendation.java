package com.topicMotivation.model;


import java.util.List;

public class Recommendation {

    private Long id;
    private String title;
    private String type; // libro, película, canción
    private String autor;
    private String description;
    private String link;

    private List<String> labels;
}