package ua.gudz.hw7.task2;

public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;
    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }
    public int getScholarship() {
        int sum;
        if (averageMark == 5) {
            sum = 100;
        } else
            sum = 80;
        return sum;
    }
}
