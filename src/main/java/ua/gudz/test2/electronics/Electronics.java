package ua.gudz.test2.electronics;

import lombok.Data;

@Data
public class Electronics {
    private String type;
    private String series;
    private String screenType;
    private int price;


    public Electronics(String type, String series, String screenType, int price) {
        this.type = type;
        this.series = series;
        this.screenType = screenType;
        this.price = price;
    }

    public Electronics() {
    }
}
