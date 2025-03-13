package com.topicMotivation.service.api.BooksGetter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topicMotivation.model.Recommendation;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleBooksAPI {

    private final String GOOGLE_BOOKS_API_BASE_URL = "https://www.googleapis.com/books/v1/volumes";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Recommendation> getBookRecommendations(String topic) {
        String url = GOOGLE_BOOKS_API_BASE_URL + "?q=" + topic + "&maxResults=10";

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return parseResponseToRecommendations(response.getBody(), topic);
            } else {
                System.err.println("Error en la API de Google Books: " + response.getStatusCode());
                return new ArrayList<>();
            }
        } catch (Exception e) {
            System.err.println("Error al conectar con Google Books: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Recommendation> parseResponseToRecommendations(String responseBody, String topic) {
        List<Recommendation> recommendations = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode items = root.path("items");

            for (JsonNode item : items) {
                JsonNode volumeInfo = item.path("volumeInfo");

                // Obtener autores
                List<String> authors = new ArrayList<>();
                if (volumeInfo.has("authors")) {
                    for (JsonNode author : volumeInfo.path("authors")) {
                        authors.add(author.asText());
                    }
                }
                String author = !authors.isEmpty() ? authors.get(0) : "Autor desconocido";

                // Obtener descripción
                String description = volumeInfo.path("description").asText();
                if (description.length() > 200) {
                    description = description.substring(0, 197) + "...";
                }

                // Obtener enlace
                String link = volumeInfo.path("infoLink").asText();
                if (link.isEmpty()) {
                    link = "https://books.google.com/books?id=" + item.path("id").asText();
                }

                Recommendation recommendation = Recommendation.builder()
                        .id(item.path("id").asLong())
                        .title(volumeInfo.path("title").asText())
                        .type("book")
                        .autor(author)
                        .description(description)
                        .link(link)
                        .labels(List.of(topic))
                        .build();
                recommendations.add(recommendation);
            }
        } catch (Exception e) {
            System.err.println("Error al parsear la respuesta de Google Books: " + e.getMessage());
        }
        return recommendations;
    }
}