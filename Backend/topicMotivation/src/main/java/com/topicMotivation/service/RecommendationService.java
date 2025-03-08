package com.topicMotivation.service;

import com.topicMotivation.model.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    public List<Recommendation> searchForLabels(String label) {
        Recommendation recommendation1 = Recommendation.builder()
                .id(1L)
                .autor("LucasFilm")
                .title("Guerra de los clones")
                .type("Pelicula")
                .link("star-wars.com")
                .description("Pelicula de clones")
                .labels(List.of("Ciencia Ficcion"))
                .build();

        return List.of(recommendation1); //TODO: agregar toda la logica que resuelva la busqueda (CORE)
    }

}
