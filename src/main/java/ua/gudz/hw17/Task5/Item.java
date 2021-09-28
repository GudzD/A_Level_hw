package ua.gudz.hw17.Task5;

import lombok.Data;

@Data
class Item {
    String name;
    int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
