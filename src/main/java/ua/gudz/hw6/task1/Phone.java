package ua.gudz.hw6.task1;

public class Phone {
    int number;
    String model = "";
    int weight;

    public Phone() {
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

//        static Phone one = new Phone(52, "Samsung", 199);
//        static Phone two = new Phone(3330, "Nokia", 230);
//        static Phone three = new Phone(10, "Iphone", 201);

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public int getNumber() {
        return number;
    }

    public static void main(String[] args) {
        Phone one = new Phone();
        one.number = 52;
        one.model = "Samsung";
        one.weight = 199;
        Phone two = new Phone(3330, "Nokia", 230);
        Phone three = new Phone(10, "Iphone", 201);
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(one.getNumber());
        System.out.println(two.getNumber());
        System.out.println(three.getNumber());
        one.receiveCall("Олег");
        two.receiveCall("Саша");
        three.receiveCall("Яна");

    }
}