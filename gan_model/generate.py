# generate.py
import torch
from torchvision.utils import save_image
import sys
import os

output_dir = "images/generated"
os.makedirs(output_dir, exist_ok=True)

# Dummy GAN image generator (replace with actual GAN model)
def generate_image(filename):
    image = torch.rand((1, 1, 28, 28))  # Fake 28x28 image
    save_image(image, os.path.join(output_dir, filename))
    print(f"Image saved: {os.path.join(output_dir, filename)}")

if __name__ == "__main__":
    # Use provided filename or default
    if len(sys.argv) > 1:
        filename = sys.argv[1]
    else:
        filename = "default.png"
    generate_image(filename)
