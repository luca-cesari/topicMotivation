package com.topicMotivation.service.api.MoviesGetter;

import com.topicMotivation.model.Recommendation;

import java.util.List;

public interface MovieRecommendationTMDBAdapter {

    public List<Recommendation> getMovieRecommendations(String topic);

}
