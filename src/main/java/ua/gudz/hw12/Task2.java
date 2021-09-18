package ua.gudz.hw12;
// Создайте класс с двумя методами f( ) и g( ). В g( ) выбросите исключение 1. В f( ) вызовите g( ),
// поймайте его исключение и в блоке catch, выбросите другое исключение 2. Проверьте ваш код в main( ).

import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        f();
    }

    static void g() throws IOException {
        throw new IOException(" Исключение 1 ");
    }

    static void f() {
        try {
            g();
        } catch (IOException e) {
            throw new RuntimeException(" Исключение 2 ");
        }
    }
}
