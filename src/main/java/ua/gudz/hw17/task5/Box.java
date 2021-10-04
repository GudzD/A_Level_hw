package ua.gudz.hw17.task5;

import lombok.Data;

import java.util.List;

@Data
public class Box {
    int size;
    List<Item> myListOfItems;

    public Box(int size, List<Item> myListOfItems) {
        this.size = size;
        this.myListOfItems = myListOfItems;
    }
}
