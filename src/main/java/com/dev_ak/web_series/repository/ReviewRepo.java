package com.dev_ak.web_series.repository;

import com.dev_ak.web_series.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
