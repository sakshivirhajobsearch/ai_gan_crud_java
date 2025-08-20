package com.ai.gan.crud.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

	public void generateGanImage(String filename) throws IOException, InterruptedException {
		
		// Call Python GAN script
		ProcessBuilder pb = new ProcessBuilder("python", "gan_model/generate.py", filename);
		pb.inheritIO(); // optional: to show Python output in console
		Process p = pb.start();
		p.waitFor();
	}
}