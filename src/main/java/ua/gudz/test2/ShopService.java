package ua.gudz.test2;

import lombok.Data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
class ShopService {
    private Object Telephone;
    private String[] randomItems;
    private ArrayList<Electronics> allObjectArrayList = new ArrayList<>(22);
    private ArrayList<Electronics> order = new ArrayList<>(5);
    private int sum;


    void read(File file) {
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
                for (int i = 0; i < 4; i++) {
                    Random rn = new Random();
                    order.add(allObjectArrayList.get(rn.nextInt(20)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    int sum(ArrayList<Electronics> in) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += in.get(i).getPrice();
        }
        System.out.println(sum + "!!!!!!");
        return sum;
    }

    void write(ArrayList<? extends Electronics> in) {
        try {;
            FileOutputStream fos = new FileOutputStream("src/main/resources/myListOrder.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(in);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



