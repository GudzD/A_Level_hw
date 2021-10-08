package ua.gudz.test2;

import lombok.Data;

@Data
class Electronics {
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
}
