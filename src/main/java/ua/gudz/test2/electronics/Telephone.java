package ua.gudz.test2.electronics;

import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)

public class Telephone extends Electronics {
    public String model;
    private static String type;


    public Telephone(String type, String series, String model, String screenType, int price) {
        super(type, series, screenType, price);
        this.model = model;
    }

    public Telephone() {
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "type=" + getType() +
                ", price=" + getPrice() +
                ", screenType='" + getScreenType() + '\'' +
                ", series='" + getSeries() + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
