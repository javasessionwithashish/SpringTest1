package com.virinchi.controller;

import com.virinchi.model.ImageClass;
import com.virinchi.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class GalleryController {

    @Autowired
    private ImageRepository imageRepo;

    @GetMapping("/gallery")
    public String gallery() {
        return "gallery";
    }


    @PostMapping("/gallery")
    public String galleryPost(@RequestParam("image") MultipartFile image)
    {
        try {
            byte[] imgBytes= image.getBytes();

//REPO'S save function .i.e imgRepo.save( object of image)
 //It always saves the object of the model class.

 ImageClass imgObj= new ImageClass();
 String imgString= Base64.getEncoder().encodeToString(imgBytes);
 //Sets the image data after its encoded in string
 imgObj.setImage(imgString);

 imageRepo.save(imgObj);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "gallery";
    }
}
