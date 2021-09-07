package ua.gudz.hw7.task2;

public class Task2 {
    public static void main(String[] args) {
        Student student = new Student("Илья", "Муромец", "1а", 4.4);
        Student aspirant1 = new Aspirant("Алеша", "Попович", "1б", 3, "Как отбить нападение Хана");
        Aspirant aspirant2 = new Aspirant("Добрыня", "Никитич", "1с", 5, "Как защищать Русь");
        Student[] students = {student, aspirant1, aspirant2};
        for (Student number : students) {
            System.out.println(number.getScholarship());
        }
    }
}


