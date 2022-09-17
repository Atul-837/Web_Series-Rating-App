package com.dev_ak.web_series.repository;

import com.dev_ak.web_series.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface ImageRepo extends JpaRepository<Image, String> {

}
