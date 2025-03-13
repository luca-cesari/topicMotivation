package com.topicMotivation.model;

import com.topicMotivation.service.api.BooksGetter.BookRecommendationGoogleAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksRecommendator {

    @Autowired
    private BookRecommendationGoogleAdapter bookRecommendationGoogleAdapter;

    public List<Recommendation> getBooksThatMatchWith(String label) {
        return bookRecommendationGoogleAdapter.getBookRecommendations(label);
    }
}