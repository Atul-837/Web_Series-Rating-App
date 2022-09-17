package com.dev_ak.web_series.service;

import com.dev_ak.web_series.entity.WebSeries;
import com.dev_ak.web_series.repository.WebSeriesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WebSeriesService {
    private final WebSeriesRepo webSeriesRepo;

    public WebSeries createWebSeries(WebSeries webSeries) {
        return this.webSeriesRepo.save(webSeries);
    }

    public WebSeries updateWebSeries(WebSeries webSeries) {
        return this.webSeriesRepo.save(webSeries);
    }

    public List<WebSeries> getAllWebSeries() {
        return this.webSeriesRepo.findAll();
    }

    public Optional<WebSeries> getById(long id) {
        return this.webSeriesRepo.findById(id);
    }
}
