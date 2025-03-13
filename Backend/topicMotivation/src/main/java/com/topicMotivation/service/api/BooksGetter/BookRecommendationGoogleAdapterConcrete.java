package com.topicMotivation.service.api.BooksGetter;

import com.topicMotivation.model.Recommendation;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BookRecommendationGoogleAdapterConcrete implements BookRecommendationGoogleAdapter {

    GoogleBooksAPI googleBooksAPI = new GoogleBooksAPI();

    @Override
    public List<Recommendation> getBookRecommendations(String topic) {
        return googleBooksAPI.getBookRecommendations(topic);
    }
}