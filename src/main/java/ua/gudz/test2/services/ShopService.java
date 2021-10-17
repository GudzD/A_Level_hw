package ua.gudz.test2.services;

import lombok.Data;
import ua.gudz.test2.Invoice;
import ua.gudz.test2.electronics.Electronics;
import ua.gudz.test2.electronics.Telephone;
import ua.gudz.test2.electronics.Television;
import ua.gudz.test2.exeptions.MyException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
public class ShopService {
    private String[] randomItems;
    private ArrayList<Electronics> allObjectArrayList = new ArrayList<>(22);
//    private ArrayList<Electronics> order = new ArrayList<>(5);


    public void read(File file) {
        if (file.exists()) {
            try {
                List<String> list = Files.readAllLines(Paths.get(String.valueOf(file)));
                randomItems = list.toArray(new String[0]);
                for (int i = 1; i < randomItems.length; i++) {
                    Matcher matcherTelephone = Pattern.compile("Telephone,(.+?),(.+?)," +
                            "(.+?),(.+?),(.+?),(.+?)$").matcher(randomItems[i]);
                    Matcher matcherTelevision = Pattern.compile("Television,(.+?),(.+?)," +
                            "(.+?),(.+?),(.+?),(.+?)$").matcher(randomItems[i]);
                    if (matcherTelephone.find()) {
                        allObjectArrayList.add(new Telephone("Telephone"
                                , matcherTelephone.group(1)
                                , matcherTelephone.group(2)
                                , matcherTelephone.group(4)
                                , Integer.parseInt(matcherTelephone.group(6))));
                    } else if (matcherTelevision.find()) {
                        allObjectArrayList.add(new Television("Television"
                                , matcherTelevision.group(1)
                                , Integer.parseInt(matcherTelevision.group(3))
                                , matcherTelevision.group(4)
                                , matcherTelevision.group(5)
                                , Integer.parseInt(matcherTelevision.group(6))));
                    } else
                        try {
                            throw new MyException("Broken String");
                        } catch (MyException e) {
                            e.printStackTrace();
                        }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Electronics> createOrder() {
        ArrayList<Electronics> order = new ArrayList<>(5);
        for (int i = 0; i < 4; i++) {
            Random rn = new Random();
            order.add(allObjectArrayList.get(rn.nextInt(20)));
        }
        return order;
    }

    public int sum(ArrayList<Electronics> in) {
        int sum = 0;
        try {
            for (int i = 0; i < 4; i++) {
                sum += in.get(i).getPrice();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public void write(Invoice invoice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/myListOrder.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(System.lineSeparator() + "Date: " + (LocalDateTime.now().format(formatter))
                    + " " + invoice);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    Написать метод который сортирует (любым известным способом) все заказы в следующем порядке:
//Сначала по возрасту покупателя от большего к меньшему
//Далее по количеству купленных предметов
//Далее по общей сумме купленных предметов

    public void mySort(ArrayList<Invoice> in) {
        in.stream()
                .sorted(Comparator.comparing((Invoice x) -> x.getMyCustomer().getAge()).reversed()
                        .thenComparing(x -> x.getList().size())
                        .thenComparing(x -> x.getList().stream()
                                .map(Electronics::getPrice)
                                .mapToInt(Integer::valueOf)
                                .sum()))
                .forEach(System.out::println);
    }
}



