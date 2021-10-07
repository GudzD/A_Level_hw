package ua.gudz.test2;

import lombok.Data;

@Data
 class Telephone extends Electronics {
    private String series;
    private String model;
    private String screenType;
    private int price;

    public Telephone(String series, String model, String screenType, int price) {
        this.series = series;
        this.model = model;
        this.screenType = screenType;
        this.price = price;
    }

    public Telephone() {
    }
}
