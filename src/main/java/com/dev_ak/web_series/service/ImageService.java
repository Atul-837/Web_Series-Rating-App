package com.dev_ak.web_series.service;

import com.dev_ak.web_series.entity.Image;
import com.dev_ak.web_series.repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageService{
    private static String uploadFilePath = System.getProperty("user.dir") + "/src/main/resources/static/images/";
    private final ImageRepo repo;

    public void uploadToDb(MultipartFile file) {
        Image image = new Image();
        try {
            image.setName(file.getOriginalFilename());
            image.setType(file.getContentType());
            image.setData(file.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.repo.save(image);
    }

    public void uploadToLocal(MultipartFile file){
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFilePath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
