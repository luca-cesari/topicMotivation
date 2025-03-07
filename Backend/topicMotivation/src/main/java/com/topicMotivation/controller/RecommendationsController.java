package com.topicMotivation.controller;

import com.topicMotivation.model.Recommendation;
import com.topicMotivation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationsController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping
    public List<Recommendation> obtenerRecomendaciones(@RequestParam List<String> labels) {
        return recommendationService.searchForLabels(labels);
    }

}


