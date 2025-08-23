package com.ai.gan.crud.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ai.gan.crud.model.ImageData;

public interface ImageRepository extends JpaRepository<ImageData, Long> {
}