package ua.gudz.hw23.entity;

//   1. Таблица устройство содержит:
//      1. Идентификатор
//      2. Тип
//      3. Название модели
//      4. Цену
//      5. Дату создания
//      6. Поле описание (текст может быть большим)
//      7. Флаг наличие на складе
//      8. Идентификатор завода

import lombok.Data;

import java.time.LocalDate;

@Data
public class Device {
    private Integer device_id;
    private String type;
    private String model;
    private Integer price;
    private LocalDate creatingData;
    private String descriptions;
    private boolean availableOnFactory;
    private Integer factory_id;

    public Device(Integer device_id, String type, String model, Integer price,
                  LocalDate creatingData, String descriptions, boolean availableOnFactory, Integer factory_id) {
        this.device_id = device_id;
        this.type = type;
        this.model = model;
        this.price = price;
        this.creatingData = creatingData;
        this.descriptions = descriptions;
        this.availableOnFactory = availableOnFactory;
        this.factory_id = factory_id;
    }

}

