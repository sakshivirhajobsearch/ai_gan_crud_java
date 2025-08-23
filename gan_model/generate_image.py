# generate_image.py
import sys
from PIL import Image
import numpy as np
import os

def generate_fake_image(filename):
    array = np.random.rand(128, 128, 3) * 255
    img = Image.fromarray(array.astype('uint8')).convert('RGB')
    os.makedirs("src/main/resources/static/images", exist_ok=True)
    img.save(f"src/main/resources/static/images/{filename}")

if __name__ == "__main__":
    filename = sys.argv[1]
    generate_fake_image(filename)
