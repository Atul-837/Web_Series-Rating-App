package com.dev_ak.web_series.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;
    @Column(name = "Rating")
    private int stars;
    @Column(name = "Review")
    private String reviewText;
    @Column(name = "Date")
    private LocalDate date = LocalDate.now();
    @ManyToOne(targetEntity = WebSeries.class)
    @JoinColumn(name = "web_series_id")
    private WebSeries webSeries;

    public void setWebSeries(WebSeries webSeries) {
        this.webSeries = webSeries;
    }
}