package com.ai.gan.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.gan.crud.model.ImageData;
import com.ai.gan.crud.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {

	private final ImageService service;

	public ImageController(ImageService service) {
		this.service = service;
	}

	@PostMapping
	public ImageData create(@RequestBody ImageData data) throws IOException {
		return service.create(data);
	}

	@GetMapping
	public List<ImageData> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ImageData get(@PathVariable Long id) {
		return service.get(id).orElse(null);
	}

	@PutMapping("/{id}")
	public ImageData update(@PathVariable Long id, @RequestBody ImageData data) {
		return service.update(id, data);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}