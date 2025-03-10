package com.topicMotivation.service;

import com.topicMotivation.model.MoviesRecommendator;
import com.topicMotivation.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    MoviesRecommendator MoviesRecommendator;

    public List<Recommendation> searchForLabels(String label) {
        return MoviesRecommendator.getMoviesThatMatchWith(label);
    }

}
