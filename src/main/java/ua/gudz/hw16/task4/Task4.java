package ua.gudz.hw16.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Anton", "Java", 5, 4));
        students.add(new Student("Dmitrii", "Scala", 3, 4));
        students.add(new Student("Sergey", "Python", 6, 4));
        students.add(new Student("Andrey", "C++", 2, 3));
        students.add(new Student("Rita", "Python", 1, 5));
        students.add(new Student("Nina", "C#", 3, 3));
        students.add(new Student("Katya", "JavaScript", 5, 1));
        students.add(new Student("Mandalorian", "Bounty hunters", 4, 5));
    }
}