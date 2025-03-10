package com.topicMotivation.model;

import com.topicMotivation.service.api.MoviesGetter.MovieRecommendationTMDBAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoviesRecommendator {

    @Autowired
    MovieRecommendationTMDBAPI movieRecommendationTMDBAPI;
    public List<Recommendation> getMoviesThatMatchWith(String label) {

        return this.movieRecommendationTMDBAPI.getMovieRecommendations(label); //TODO: Conviene desacoplar con un adapter

    }
}
