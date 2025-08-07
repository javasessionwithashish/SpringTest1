package com.virinchi.model;

import jakarta.persistence.*;

@Entity
public class ImageClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob //Large Objects- Byte as String
    @Column (columnDefinition = "mediumblob")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
