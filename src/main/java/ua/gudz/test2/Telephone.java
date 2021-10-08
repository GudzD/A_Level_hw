package ua.gudz.test2;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@SuppressWarnings("Lombok")
@EqualsAndHashCode(callSuper = true)
@Data
class Telephone extends Electronics implements Serializable {
    private String model;
    private static String type;


    public Telephone(String type, String series, String model, String screenType, int price) {
        super(type, series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "price=" + getPrice() +
                ", screenType='" + getScreenType() + '\'' +
                ", series='" + getSeries() + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
