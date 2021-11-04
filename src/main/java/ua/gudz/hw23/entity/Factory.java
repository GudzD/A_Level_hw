package ua.gudz.hw23.entity;

import lombok.Data;

//2. Таблица завод содержит:
//      1. Идентификатор
//      2. Название
//      3. Страну
@Data
public class Factory {
    private Integer id;
    private String name;
    private String country;

    public Factory(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
