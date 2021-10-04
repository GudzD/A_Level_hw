package ua.gudz.hw18.task1;

import lombok.Data;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Data
class Box {
    private String from;
    private String material;
    private String color;
    private int maxLiftingCapacity;
    private String unit;
    private Date deliveryDate;
    private Cargo cargo = new Cargo();

    Box(File file) {
        if (file.getPath().endsWith(".xml")) {
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
//                System.out.println(xml);
                Matcher matcherXml = Pattern
                        .compile("from=\"(...+?)\".+?\"(.....+?)\".+?>(.+?)<.+?unit=." +
                                "(.+).>(\\d.+?)<.+?name>(.+?)<.+?class>(.+?)<.+?date>(.+?)<")
                        .matcher(xml);
                if (matcherXml.find()) {
                    from = matcherXml.group(1);
                    material = matcherXml.group(2);
                    color = matcherXml.group(3);
                    unit = matcherXml.group(4);
                    maxLiftingCapacity = Integer.parseInt(matcherXml.group(5));
                    cargo.name = matcherXml.group(6);
                    cargo.cargoClass = matcherXml.group(7);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd't'HH:mm:ss");
                    try {
                        deliveryDate = dateFormat.parse(matcherXml.group(8));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (file.getPath().endsWith(".json")) {
            try (FileInputStream fis = new FileInputStream(file)) {
                Reader fr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(fr);
                StringBuilder str = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    str.append(line);
                    line = br.readLine();
                }
                String jsonDateOfDelivery = str.toString().replaceAll("[\s\t+<>{}\"]", "")
                        .toLowerCase(Locale.ROOT);
                String json = jsonDateOfDelivery.replaceAll("[:,]", " ");
//                System.out.println(jsonDateOfDelivery);
                String[] jsonArray = json.split(" ");
                Matcher matcherJson = Pattern
                        .compile("date:(.+?)\\Z")
                        .matcher(jsonDateOfDelivery);
                IntStream.range(0, jsonArray.length).forEach(i -> {
                    if (jsonArray[i].equals("from")) from = jsonArray[i + 1];
                    if (jsonArray[i].equals("material")) material = jsonArray[i + 1];
                    if (jsonArray[i].equals("color")) color = jsonArray[i + 1];
                    if (jsonArray[i].equals("unit")) unit = jsonArray[i + 1];
                    if (jsonArray[i].equals("value")) maxLiftingCapacity = Integer.parseInt(jsonArray[i + 1]);
                    if (jsonArray[i].equals("name")) cargo.name = jsonArray[i + 1];
                    if (jsonArray[i].equals("class")) cargo.cargoClass = jsonArray[i + 1];
                });
                if (matcherJson.find()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd't'HH:mm:ss");
                    try {
                        deliveryDate = dateFormat.parse(matcherJson.group(1));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}