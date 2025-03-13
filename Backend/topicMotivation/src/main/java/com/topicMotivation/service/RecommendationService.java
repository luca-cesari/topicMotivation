package com.topicMotivation.service;

import com.topicMotivation.model.BooksRecommendator;
import com.topicMotivation.model.MoviesRecommendator;
import com.topicMotivation.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    MoviesRecommendator moviesRecommendator;

    @Autowired
    BooksRecommendator booksRecommendator;

    public List<Recommendation> searchForLabels(String label) {
        List<Recommendation> allRecommendations = new ArrayList<>();

        // Obtener recomendaciones de películas
        allRecommendations.addAll(moviesRecommendator.getMoviesThatMatchWith(label));

        // Obtener recomendaciones de libros
        allRecommendations.addAll(booksRecommendator.getBooksThatMatchWith(label));

        // Ordenar alfabéticamente por título
        allRecommendations.sort(Comparator.comparing(Recommendation::getTitle, String.CASE_INSENSITIVE_ORDER));

        return allRecommendations;
    }

}
