package com.topicMotivation.controller;

import com.topicMotivation.model.Recommendation;
import com.topicMotivation.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationsController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping
    public List<Recommendation> obtenerRecomendaciones(@RequestParam String label) {
        return recommendationService.searchForLabels(label);
    }

}


