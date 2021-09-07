package ua.gudz.hw1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Task2 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy kk:mm:ss");
        System.out.println("Gudz Dmitrii " + dateFormat.format(Calendar.getInstance().getTime()));
    }
}