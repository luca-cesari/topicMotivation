package com.topicMotivation.service.api.BooksGetter;

import com.topicMotivation.model.Recommendation;
import java.util.List;

public interface BookRecommendationGoogleAdapter {
    List<Recommendation> getBookRecommendations(String topic);
}