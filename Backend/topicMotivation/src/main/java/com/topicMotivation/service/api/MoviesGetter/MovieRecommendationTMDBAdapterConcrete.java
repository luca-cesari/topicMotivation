package com.topicMotivation.service.api.MoviesGetter;

import com.topicMotivation.model.Recommendation;

import java.util.List;

public class MovieRecommendationTMDBAdapterConcrete implements MovieRecommendationTMDBAdapter {

    TMDBAPI tmdbapi = new TMDBAPI();
    @Override
    public List<Recommendation> getMovieRecommendations(String topic) {
        return tmdbapi.getMovieRecommendations(topic);
    }
}
