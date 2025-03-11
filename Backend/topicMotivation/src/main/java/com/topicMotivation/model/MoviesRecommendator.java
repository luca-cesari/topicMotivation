package com.topicMotivation.model;

import com.topicMotivation.service.api.MoviesGetter.TMDBAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoviesRecommendator {

    @Autowired
    TMDBAPI TMDBAPI;
    public List<Recommendation> getMoviesThatMatchWith(String label) {

        return this.TMDBAPI.getMovieRecommendations(label);

    }
}
