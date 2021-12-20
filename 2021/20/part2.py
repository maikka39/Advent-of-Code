#!/usr/bin/env python3
import numpy as np

with open("input.txt", "r") as file:
    algorithm = np.array(
        [char == "#" for char in file.readline()])
    image = np.array([[c == '#' for c in line.strip()]
                      for line in file.readlines()[1:]])


def expand(image: np.ndarray, fill: int) -> np.ndarray:
    expand = np.zeros(
        (image.shape[0]+2, image.shape[1]+2),
        dtype="uint16"
    ) + fill

    expand[1:-1, 1:-1] = image
    return expand


fill = 0
image = expand(image, fill)

for _ in range(50):
    image = expand(image, fill)

    replacement_map = (
        (image[:-2, :-2] << 8)
        | (image[:-2, 1:-1] << 7)
        | (image[:-2, 2:] << 6)
        | (image[1:-1, :-2] << 5)
        | (image[1:-1, 1:-1] << 4)
        | (image[1:-1, 2:] << 3)
        | (image[2:, :-2] << 2)
        | (image[2:, 1:-1] << 1)
        | (image[2:, 2:]))

    fill = algorithm[0] if fill == 0 else algorithm[0b111111111]
    image[:, :] = fill
    image[1:-1, 1:-1] = algorithm[replacement_map]

print(np.count_nonzero(image))
