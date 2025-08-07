package com.virinchi.repository;

import com.virinchi.model.ImageClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageClass, Integer> {
}
