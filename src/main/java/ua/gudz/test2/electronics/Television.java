package ua.gudz.test2.electronics;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
public class Television extends Electronics implements Serializable {
    private int diagonal;
    private String country;
    private static String type;

    public Television(String type, String series, int diagonal, String screenType, String country, int price) {
        super(type, series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    public Television() {
    }

    @Override
    public String toString() {
        return "Television{" +
                "type=" + getType() +
                ", price=" + getPrice() +
                ", screenType='" + getScreenType() + '\'' +
                ", series='" + getSeries() + '\'' +
                ", diagonal=" + diagonal +
                ", country='" + country + '\'' +
                '}';
    }
}
