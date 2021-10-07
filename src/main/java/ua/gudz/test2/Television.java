package ua.gudz.test2;

import lombok.Data;

@Data
public class Television extends Electronics{
    private String series;
    private int diagonal;
    private String screenType;
    private String country;
    private int price;

    public Television(String series, int diagonal, String screenType, String country, int price) {
        this.series = series;
        this.diagonal = diagonal;
        this.screenType = screenType;
        this.country = country;
        this.price = price;
    }

    public Television() {
    }
}
