package com.ai.gan.crud.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ai.gan.crud.model.ImageData;
import com.ai.gan.crud.service.repository.ImageRepository;

@Service
public class ImageService {
	private final ImageRepository repository;

	public ImageService(ImageRepository repository) {
		this.repository = repository;
	}

	public ImageData create(ImageData data) throws IOException {
		// Call Python GAN script
		String filename = "image_" + System.currentTimeMillis() + ".png";

		ProcessBuilder pb = new ProcessBuilder("python3", "generate_image.py", filename);
		pb.inheritIO().start();

		data.setFilename(filename);
		return repository.save(data);
	}

	public List<ImageData> getAll() {
		return repository.findAll();
	}

	public Optional<ImageData> get(Long id) {
		return repository.findById(id);
	}

	public ImageData update(Long id, ImageData updated) {
		return repository.findById(id).map(existing -> {
			existing.setDescription(updated.getDescription());
			return repository.save(existing);
		}).orElse(null);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}