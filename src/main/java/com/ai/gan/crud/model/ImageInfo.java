package com.ai.gan.crud.model;

public class ImageInfo {
	
	private String filename;

	public ImageInfo() {
	}

	public ImageInfo(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
}