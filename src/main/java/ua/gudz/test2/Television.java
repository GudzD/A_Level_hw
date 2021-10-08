package ua.gudz.test2;

import lombok.Data;

import java.io.Serializable;

@SuppressWarnings("ALL")
@Data
class Television extends Electronics implements Serializable {
    private int diagonal;
    private String country;
    private static String type;

    public Television(String type, String series, int diagonal, String screenType, String country, int price) {
        super(type, series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television{" +
                "price=" + getPrice() +
                ", screenType='" + getScreenType() + '\'' +
                ", series='" + getSeries() + '\'' +
                ", diagonal=" + diagonal +
                ", country='" + country + '\'' +
                '}';
    }
}
