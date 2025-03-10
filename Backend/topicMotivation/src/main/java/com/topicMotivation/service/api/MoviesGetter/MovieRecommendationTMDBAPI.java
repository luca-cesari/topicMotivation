package com.topicMotivation.service.api.MoviesGetter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topicMotivation.model.Recommendation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieRecommendationTMDBAPI {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final String TMDB_API_BASE_URL = "https://api.themoviedb.org/3/search/movie";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Recommendation> getMovieRecommendations(String topic) {
        String url = TMDB_API_BASE_URL + "?api_key=" + apiKey + "&query=" + topic;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return parseResponseToRecommendations(response.getBody());
            } else {
                System.err.println("Error en la API de TMDB: " + response.getStatusCode());
                return new ArrayList<>();
            }
        } catch (Exception e) {
            System.err.println("Error al conectar con TMDB: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Recommendation> parseResponseToRecommendations(String responseBody) {
        List<Recommendation> recommendations = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode results = root.path("results");

            for (JsonNode result : results) {
                Recommendation recommendation = Recommendation.builder()
                        .id(result.path("id").asLong())
                        .title(result.path("title").asText())
                        .type("película")
                        .description(result.path("overview").asText())
                        .link("https://www.themoviedb.org/movie/" + result.path("id").asLong())
                        .build();
                recommendations.add(recommendation);
            }
        } catch (Exception e) {
            System.err.println("Error al parsear la respuesta de TMDB: " + e.getMessage());
        }
        return recommendations;
    }
}
