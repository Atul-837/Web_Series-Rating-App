package com.dev_ak.web_series.repository;

import com.dev_ak.web_series.entity.WebSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebSeriesRepo extends JpaRepository<WebSeries, Long> {

}
