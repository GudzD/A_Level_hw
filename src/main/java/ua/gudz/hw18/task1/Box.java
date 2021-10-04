package ua.gudz.hw18.task1;

import lombok.Data;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
class Box {
    private String from;
    private String material;
    private String color;
    private int maxLiftingCapacity;
    private Date deliveryDate;
    private Cargo cargo = new Cargo();


    public Box() {
    }

    Box(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Reader fr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder str = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                str.append(line);
                line = br.readLine();
            }
            String xml = str.toString().replaceAll("[\\s\\t+]", "").toLowerCase(Locale.ROOT);
            System.out.println(xml);
            Matcher matcherXml = Pattern
                    .compile("from=\"(...+?)\".+?\"(.....+?)\".+?>(.+?)<.+?>(\\d.+?)<" +
                            ".+?name>(.+?)<.+?class>(.+?)<.+?date>(.+?)<")
                    .matcher(xml);
            if (matcherXml.find()) {
                from = matcherXml.group(1);
                material = matcherXml.group(2);
                color = matcherXml.group(3);
                maxLiftingCapacity = Integer.parseInt(matcherXml.group(4));
                cargo.name = matcherXml.group(5);
                cargo.cargoClass = matcherXml.group(6);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd't'HH:mm:ss");
                try {
                    deliveryDate = dateFormat.parse(matcherXml.group(7));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}