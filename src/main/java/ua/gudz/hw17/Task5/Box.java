package ua.gudz.hw17.Task5;

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
//   ArrayList<Item> list1 = new ArrayList<>();
//   ArrayList<Item> list2 = new ArrayList<>();
//   ArrayList<Item> list3 = new ArrayList<>();
//   ArrayList<Item> list4 = new ArrayList<>();
//   ArrayList<Item> list5 = new ArrayList<>();
//   ArrayList<Item> list6 = new ArrayList<>();
//   ArrayList<Item> list7 = new ArrayList<>();
//   ArrayList<Item> list8 = new ArrayList<>();
//   ArrayList<Item> list9 = new ArrayList<>();
//   ArrayList<Item> list10 = new ArrayList<>();
}
