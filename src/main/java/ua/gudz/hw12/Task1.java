package ua.gudz.hw12;

// Создайте класс с main( ), который выбрасывает объект, класса Exception внутри блока try.
// Передайте конструктору Exception аргумент String. Поймайте исключение внутри  блока catch и
// напечатайте аргумент String. Добавьте блок finally и напечатайте сообщение, чтобы убедится, что вы были там.

public class Task1 {
    public static void main(String[] args) {
        try {
            throw new Exception("Исключение");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Был здесь");
        }
    }
}

