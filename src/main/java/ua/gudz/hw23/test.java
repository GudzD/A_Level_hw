package ua.gudz.hw23;

//Предварительно создать базу данных
//1. Написать класс, который создает две таблицы - Устройство, Завод
//   1. Таблица устройство содержит:
//      1. Идентификатор
//      2. Тип
//      3. Название модели
//      4. Цену
//      5. Дату создания
//      6. Поле описание (текст может быть большим)
//      7. Флаг наличие на складе
//      8. Идентификатор завода
//   2. Таблица завод содержит:
//      1. Идентификатор
//      2. Название
//      3. Страну
//2. Написать класс который
//   1. генерирует 10 устройств и 4 завода. Связывает устройства с заводами и сохраняет в базу данных
//   2. достает информацию по конкретному устройству и заводу изготовителю  -
//   отображает пользователю (необходимо преобразование из ResultSet в POJO)
//   3. изменяет данные этого устройства и сохраняет в базу
//   4. удаляет конкретное устройство
//   5. Достает список всех устройств изготовленных на конкретном заводе (join)
//   6. Достает количество устройств, сумму всех устройств для каждого завода (group by)

import ua.gudz.hw23.service.FillService;
import ua.gudz.hw23.service.Service;

public class test {
    public static void main(String[] args) {
        Service service = new Service();
        FillService fillService = new FillService();
        service.createTable();
        fillService.generatesFactory().forEach(System.out::println);
        fillService.generatesDevice().forEach(System.out::println);
        fillService.factoryList.forEach(fillService::tableAddFactory);
        fillService.deviceList.forEach(fillService::tableAddDevice);
        service.infoFor(1);
        System.out.println();
        service.changeFields(3);
        service.deleteDevice(3);
        System.out.println();
        service.infoAllDevicesAndSumOfThemFromFactory();
    }
}