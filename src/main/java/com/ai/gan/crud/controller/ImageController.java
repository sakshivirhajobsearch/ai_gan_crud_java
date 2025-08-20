package com.ai.gan.crud.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.gan.crud.service.ImageService;

@RestController
public class ImageController {

	private final ImageService imageService;

	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}

	@GetMapping("/generate-image")
	public String generateImage(@RequestParam(defaultValue = "default.png") String filename) {
		try {
			imageService.generateGanImage(filename);
			return "Image generated: " + filename;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "Failed to generate image";
		}
	}
}