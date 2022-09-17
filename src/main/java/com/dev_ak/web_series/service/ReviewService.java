package com.dev_ak.web_series.service;

import com.dev_ak.web_series.entity.Review;
import com.dev_ak.web_series.entity.WebSeries;
import com.dev_ak.web_series.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final WebSeriesService webSeriesService;

    public Review createReview(Review review, Long id) {
        Optional<WebSeries> series = this.webSeriesService.getById(id);
        Review review1 = new Review();
        if (series.isPresent()) {
            WebSeries webSeries = series.get();
            Random rand = new Random();
            review.setId(rand.nextLong(Long.MAX_VALUE));
            review.setWebSeries(webSeries);
            review1 = this.reviewRepo.save(review);
            this.webSeriesService.updateWebSeries(webSeries);
        }
        return review1;
    }

    public Review updateReview(Review review) {
        return this.reviewRepo.save(review);
    }

    public Optional<Review> getById(Long id) {
        return this.reviewRepo.findById(id);
    }

    public List<Review> getAllById(Long id) {
        Optional<WebSeries> series = this.webSeriesService.getById(id);
        List<Review> reviews = this.reviewRepo.findAll();
        if (series.isPresent()) {
            WebSeries webSeries = series.get();
            reviews = webSeries.getReviews();
        }
        return reviews;
    }

    public List<Review> getAll() {
        return this.reviewRepo.findAll();
    }

}
