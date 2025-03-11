package com.topicMotivation.apis;

import com.topicMotivation.model.Recommendation;
import com.topicMotivation.service.api.MoviesGetter.TMDBAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MovieRecommendationTMDBAPITest {

    @Autowired
    private TMDBAPI TMDBAPI;

    @Test
    void testGetMovieRecommendations() {

        String topic = "Inception";


        List<Recommendation> recommendations = TMDBAPI.getMovieRecommendations(topic);


        assertNotNull(recommendations, "La lista de recomendaciones no debería ser null");
        assertFalse(recommendations.isEmpty(), "La lista de recomendaciones no debería estar vacía");


        Recommendation firstMovie = recommendations.get(0);
        assertNotNull(firstMovie.getTitle(), "El título no debería ser null");
        assertNotNull(firstMovie.getDescription(), "La descripción no debería ser null");
        assertTrue(firstMovie.getLink().contains("https://www.themoviedb.org/movie/"), "El link no es válido");


        recommendations.forEach(movie -> System.out.println(movie.getTitle() + " - " + movie.getLink()));
    }
}
