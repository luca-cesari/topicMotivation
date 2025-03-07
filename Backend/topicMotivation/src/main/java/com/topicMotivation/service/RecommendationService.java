package com.topicMotivation.service;

import com.topicMotivation.model.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    public List<Recommendation> searchForLabels(List<String> labels) {
        return List.of(); //TODO: agregar toda la logica que resuelva la busqueda (CORE)
    }

}
