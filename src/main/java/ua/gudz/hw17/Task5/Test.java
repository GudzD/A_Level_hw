package ua.gudz.hw17.Task5;

//Спроектировать обьект Box который содержит коллекцию Item и поле size. Item должен содержать поле name и cost
//Создать коллекцию Box и инициализировать ее 10 коробками
//Спроектировать метод, который случайным образом будет выбирать фильтр по размеру допустимых
// коробок из промежутка min size <= лимит <= max size
//Применить фильтр к коллекции коробок,
//У оставшихся коробок взять колеекции Item
//Отсортировать по цене
//Вывести результат в консоль

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        ArrayList<Item> list1 = new ArrayList<>();
        ArrayList<Item> list2 = new ArrayList<>();
        ArrayList<Item> list3 = new ArrayList<>();
        ArrayList<Item> list4 = new ArrayList<>();
        ArrayList<Item> list5 = new ArrayList<>();
        ArrayList<Item> list6 = new ArrayList<>();
        ArrayList<Item> list7 = new ArrayList<>();
        ArrayList<Item> list8 = new ArrayList<>();
        ArrayList<Item> list9 = new ArrayList<>();
        ArrayList<Item> list10 = new ArrayList<>();
        Item item1 = new Item("Fork1", 10);
        Item item2 = new Item("Fork2", 11);
        Item item3 = new Item("Fork3", 12);
        Item item4 = new Item("Fork4", 13);
        Item item5 = new Item("Fork5", 14);
        Item item6 = new Item("Fork6", 15);
        Item item7 = new Item("Fork7", 16);
        Item item8 = new Item("Fork8", 17);
        Item item9 = new Item("Fork9", 18);
        Item item10 = new Item("Fork10", 19);
        list1.add(item1);
        list1.add(item2);
        list2.add(item2);
        list2.add(item1);
        list3.add(item6);
        list3.add(item3);
        list4.add(item2);
        list4.add(item4);
        list5.add(item1);
        list5.add(item5);
        list6.add(item9);
        list6.add(item6);
        list7.add(item1);
        list7.add(item7);
        list8.add(item3);
        list8.add(item8);
        list9.add(item4);
        list9.add(item9);
        list10.add(item1);
        list10.add(item10);
        List<Box> myListOfBoxes = new ArrayList<>();
        myListOfBoxes.add(new Box(44, list1));
        myListOfBoxes.add(new Box(35, list2));
        myListOfBoxes.add(new Box(50, list3));
        myListOfBoxes.add(new Box(32, list4));
        myListOfBoxes.add(new Box(14, list5));
        myListOfBoxes.add(new Box(41, list6));
        myListOfBoxes.add(new Box(7, list7));
        myListOfBoxes.add(new Box(24, list8));
        myListOfBoxes.add(new Box(10, list9));
        myListOfBoxes.add(new Box(1, list10));
        correctSize(myListOfBoxes)
                .stream()
                .map(Box::getMyListOfItems)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(Item::getCost))
                .forEach(System.out::println);
    }

    private static List<Box> correctSize(List<Box> in) {
        Random random = new Random();
        int min = random.nextInt(50);
        System.out.println("Фильтр Box size от: " + min);
        // random.setSeed(min); - не понял почему не сработало
        int max = random.nextInt(50 + min);
        System.out.println("Фильтр Box size до : " + max);
        System.out.println("Что в этих коробках: ");
        return in
                .stream()
                .filter(box -> box.size >= min && box.size <= max)
                .collect(Collectors.toList());
    }
}
