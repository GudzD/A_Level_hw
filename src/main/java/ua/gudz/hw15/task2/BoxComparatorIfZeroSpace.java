package ua.gudz.hw15.task2;

import java.util.Comparator;

public class BoxComparatorIfZeroSpace implements Comparator<Box> {

    @Override
    public int compare(Box box1, Box box2) {
        int space1 = box1.getSpace();
        int space2 = box2.getSpace();
        if (space1 == 0) space1 = 0x7fffffff;
        if (space2 == 0) space2 = 0x7fffffff;
        return Integer.compare(space1, space2);
    }
}
