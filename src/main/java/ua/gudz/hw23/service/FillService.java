package ua.gudz.hw23.service;

//2. Написать класс который
//   1. генерирует 10 устройств и 4 завода. Связывает устройства с заводами и сохраняет в базу данных
//   2. достает информацию по конкретному устройству и заводу изготовителю  -
//   отображает пользователю (необходимо преобразование из ResultSet в POJO)
//   3. изменяет данные этого устройства и сохраняет в базу
//   4. удаляет конкретное устройство
//   5. Достает список всех устройств изготовленных на конкретном заводе (join)
//   6. Достает количество устройств, сумму всех устройств для каждого завода (group by)

import org.jetbrains.annotations.NotNull;
import ua.gudz.hw23.entity.Device;
import ua.gudz.hw23.entity.Factory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FillService {
    public List<Factory> factoryList = new ArrayList<>();
    public List<Device> deviceList = new ArrayList<>();
    private PreparedStatement statement;


    public List<Factory> generatesFactory() {
        String[] nameArray = {"Factory1", "Factory2", "Factory3", "Factory4"};
        String[] nameCountry = {"Usa", "Canada", "Mexico", "Cuba"};
        for (int i = 0; i < 4; i++) {
            factoryList.add(i, new Factory(i, nameArray[i], nameCountry[i]));
        }
        return factoryList;
    }

    public List<Device> generatesDevice() {
        Random rn = new Random(4);
        String[] nameType = {"Television", "Telephone", "Notebook",
                "Monitor", "Tablet", "Kettle", "Mouse", "Printer", "Scooter", "Joystick"};
        String[] nameModel = {"T01", "T02", "T03", "T04", "T05", "T06", "T07", "T08", "T09", "T10"};
        int[] price = {1000, 1200, 1500, 800, 299, 1050, 300, 255, 799, 850};
        String[] description = {"BlaBlaBla", "BlaBla", "Bla2", "Bla", "Bla-bla", "Bla, Bla", "BlaBla-Bla",
                "Bla,Bla", "Bla.Bla", "Good"};
        for (int i = 0; i < 10; i++) {
            deviceList.add(i,
                    new Device(i, nameType[i], nameModel[i], price[i],
                            LocalDate.now(), description[i], (i + 1) % 2 == 0,
                            rn.nextInt(4)));
        }
        return deviceList;
    }

    public void tableAddFactory(@NotNull Factory in) {
        ConnectionService connectionService = new ConnectionService();
        try (PreparedStatement statement = connectionService.getDBConnection().
                prepareStatement("INSERT INTO factorys (id, name, country) VALUES ((?), (?), (?));")) {
            statement.setInt(1, in.getId());
            statement.setString(2, in.getName());
            statement.setString(3, in.getCountry());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tableAddDevice(@NotNull Device in) {
        ConnectionService connectionService = new ConnectionService();
        try (PreparedStatement statement = connectionService.getDBConnection().
                prepareStatement("INSERT INTO devices (device_id, type, model, price, creatingData, descriptions, " +
                        "availableOnFactory, factory_id) VALUES ((?), (?), (?), (?), (?), (?), (?), (?));")) {
            statement.setInt(1, in.getDevice_id());
            statement.setString(2, in.getType());
            statement.setString(3, in.getModel());
            statement.setInt(4, in.getPrice());
            statement.setDate(5, Date.valueOf(in.getCreatingData()));
            statement.setString(6, in.getDescriptions());
            statement.setBoolean(7, Boolean.parseBoolean(in.toString()));
            statement.setInt(8, in.getFactory_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
