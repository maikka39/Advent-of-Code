#!/usr/bin/env python3
from collections import defaultdict

with open("input.txt", "r") as file:
    data = [line.strip().split("-") for line in file.readlines()]


class Graph:
    def __init__(self):
        self.graph_dict = defaultdict(list)

    def add_edge(self, node1, node2):
        if node1 != "end" and node2 != "start":
            self.graph_dict[node1].append(node2)
        if node1 != "start" and node2 != "end":
            self.graph_dict[node2].append(node1)

    def find_paths(self, current, end, path):
        paths = []
        path.append(current)

        if current == end:
            paths.append(path.copy())
        else:
            for dest in self.graph_dict[current]:
                if dest.isupper() or dest not in path:
                    paths += self.find_paths(dest, end, path)

        path.pop()
        return paths


graph = Graph()
for start, end in data:
    graph.add_edge(start, end)

print(len(graph.find_paths("start", "end", [])))
