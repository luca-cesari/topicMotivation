package com.topicMotivation.controller;

import com.topicMotivation.model.Recomendation;
import com.topicMotivation.service.RecomendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/recomendations")
public class RecomendationsController {

    @Autowired
    private RecomendationService recomendationService;

    @GetMapping
    public List<Recomendation> obtenerRecomendaciones(@RequestParam List<String> labels) {
        return recomendationService.searchForLabels(labels);
    }

}


