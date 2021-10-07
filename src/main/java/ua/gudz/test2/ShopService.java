package ua.gudz.test2;

import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
public class ShopService {
    static String[] randomItems;
    static Random rn = new Random();
    static ArrayList<Electronics> allObjectArrayList = new ArrayList<>(21);
    static ArrayList<Electronics> order = new ArrayList<>(5);


    static void read(File file) {
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
                        allObjectArrayList.add(new Telephone(matcherTelephone.group(1)
                                , matcherTelephone.group(2)
                                , matcherTelephone.group(4)
                                , Integer.parseInt(matcherTelephone.group(6))));
                    } else if (matcherTelevision.find()) {
                        allObjectArrayList.add(new Television(matcherTelevision.group(1)
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
                    order.add(allObjectArrayList.get(rn.nextInt(20)));
                }
//                BufferedWriter br = new BufferedWriter("Order.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     static int sum(ArrayList<Electronics> in) {
        int sum = 1;
        for (int i = 0; i < 4; i++) {
            if(in.get(i).getClass() == Telephone.class){
                in.stream()
                        .map(Telephone::getPrice)
                        .map(x->x+sum)
                        .close();
            }else {
                in.stream()
                        .map(Object::getClass)
                        .map(o->Telephone.class)
                        .peek(Telephone::getPrice)
                        .map(x->x+sum)
                        .close();
            }

        }
        System.out.println(sum + "!!!!!!");
        return sum;
    }
}



