package com.dev_ak.web_series.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "web_series_images")
@Data
public class Image {
    @Id
    @Column(name = "image_id")
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    public Image(String name, String type, byte[] data) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Image() {

    }
}
