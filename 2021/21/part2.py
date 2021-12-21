#!/usr/bin/env python3
from collections import Counter, defaultdict

with open("input.txt", "r") as file:
    data = [int(line.strip().split(": ")[1]) for line in file.readlines()]

locations = data
wins = [0, 0]

dice_probabilities = Counter(
    a + b + c
    for a in range(1, 4)
    for b in range(1, 4)
    for c in range(1, 4)
)

game_states = defaultdict(int)
game_states[((locations[0] - 1, 0), (locations[1] - 1, 0))] += 1

player = 0

while game_states:
    new_states = defaultdict(int)

    for state, state_count in game_states.items():
        for dice, dice_count in dice_probabilities.items():
            position = (state[player][0] + dice) % 10
            score = state[player][1] + position + 1

            if score >= 21:
                wins[player] += state_count * dice_count
            else:
                new_state = list(state)
                new_state[player] = (position, score)
                new_states[tuple(new_state)] += state_count * dice_count

    player = not player
    game_states = new_states

print(max(wins))
