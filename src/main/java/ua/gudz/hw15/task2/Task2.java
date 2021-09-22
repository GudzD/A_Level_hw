package ua.gudz.hw15.task2;

import java.util.Comparator;
import java.util.TreeSet;

public class Task2 {
    public static void main(String[] args) {
        Comparator<Box> comp = new BoxComparatorIfZeroSpace();
        TreeSet<Box> boxes = new TreeSet<>(comp);
        boxes.add(new Box(23));
        boxes.add(new Box(20));
        boxes.add(new Box(45));
        boxes.add(new Box(34));
        boxes.add(new Box(17));
        boxes.add(new Box(0));
        for (Box box : boxes) {
            System.out.print(box.space + " ");
        }
    }
}
