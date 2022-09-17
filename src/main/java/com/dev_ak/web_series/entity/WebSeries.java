package com.dev_ak.web_series.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "web_series")
public class WebSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "web_series_id")
    private Long id;
    @Column(name = "Name")
    private String series_name;
    @Column(name = "Seasons")
    private Integer seasons;
    @Column(name = "Episodes")
    private Integer episodes;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "Release_year")
    private Integer year;
    @Column(name = "Industry")
    private String industry;
    @Column(name = "Original_Language")
    private String language;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "webSeries", fetch = FetchType.LAZY, targetEntity = Review.class)
    private List<Review> reviews = new ArrayList<>();

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
