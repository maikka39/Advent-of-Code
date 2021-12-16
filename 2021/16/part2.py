#!/usr/bin/env python3
from __future__ import annotations

from itertools import count
from typing import Iterator
from math import prod

with open("input.txt", "r") as file:
    data = file.read()


class Packet:
    def __init__(self, binary: str) -> None:
        self.binary: str = binary

    @property
    def is_literal(self) -> bool: return self.type == 4

    @property
    def is_operator(self) -> bool: return self.type != 4

    @property
    def version(self) -> int:
        return int(self.binary[:3], 2)

    @property
    def type(self) -> int:
        return int(self.binary[3:6], 2)

    @property
    def data(self) -> str:
        return self.binary[6:]

    @property
    def value(self) -> int:
        subpacket_values = map(lambda x: x.value, self.subpackets)

        match self.type:
            case 0:
                return sum(subpacket_values)
            case 1:
                return prod(subpacket_values)
            case 2:
                return min(subpacket_values)
            case 3:
                return max(subpacket_values)
            case 4:
                return self.literal
            case 5:
                first, second = subpacket_values
                return int(first > second)
            case 6:
                first, second = subpacket_values
                return int(first < second)
            case 7:
                first, second = subpacket_values
                return int(first == second)

    @property
    def literal(self) -> int:
        out = ""
        for i in count(0, 5):
            out += self.data[i+1:i+5]

            if self.data[i] == "0":
                break

        return int(out, 2)

    @property
    def unused_bits(self) -> str:
        if self.is_literal:
            for i in count(0, 5):
                if self.data[i] == "0":
                    return self.data[i+5:]

        elif self.is_operator:
            type_id = self.data[0]
            bit_length = 15 if type_id == "0" else 11
            subpackets_length = int(self.binary[7:7+bit_length], 2)

            match type_id:
                case "0":
                    return self.data[1+bit_length+subpackets_length:]
                case "1":
                    packet_data = self.data[1+bit_length:]
                    for _ in range(subpackets_length):
                        packet_data = Packet(packet_data).unused_bits

                    return packet_data

    @property
    def subpackets(self) -> Iterator[Packet]:
        type_id = self.data[0]
        bit_length = 15 if type_id == "0" else 11
        subpackets_length = int(self.data[1:1+bit_length], 2)

        match type_id:
            case "0":
                packet_data = self.data[1+bit_length:1 +
                                        bit_length+subpackets_length]

                while "1" in packet_data:
                    packet = Packet(packet_data)
                    yield packet
                    packet_data = packet.unused_bits

            case "1":
                packet_data = self.data[1+bit_length:]
                for _ in range(subpackets_length):
                    packet = Packet(packet_data)
                    yield packet
                    packet_data = packet.unused_bits


packet = Packet("".join(bin(int(char, 16))[2:].zfill(4) for char in data))
print(packet.value)
