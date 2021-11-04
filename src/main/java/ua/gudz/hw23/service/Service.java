package ua.gudz.hw23.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//1. Написать класс который создает две таблицы - Укстройство, Завод
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

public class Service {

    public void createTable() {
        ConnectionService connectionService = new ConnectionService();
        Statement statement = null;
        try {
            statement = connectionService.getDBConnection().createStatement();
            String SQL1 = "CREATE TABLE devices " +
                    "(device_id INTEGER not NULL, " +
                    " type VARCHAR(50), " +
                    " model VARCHAR(50), " +
                    " price INTEGER not NULL, " +
                    " creatingData TIMESTAMP not NULL, " +
                    " descriptions TEXT, " +
                    " availableOnFactory BOOLEAN not NULL, " +
                    " factory_id INTEGER not NULL, " +
                    " PRIMARY KEY (device_id), " +
                    " FOREIGN KEY (factory_id) REFERENCES factorys(id))";

            String SQL2 = "CREATE TABLE factorys " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50), " +
                    " country VARCHAR(50), " +
                    " PRIMARY KEY (id))";
            statement.executeUpdate(SQL2);
            statement.executeUpdate(SQL1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        connectionService.closeConnection();
    }

    //    . достает информацию по конкретному устройству и заводу изготовителю
    public void infoFor(int id) {
        ConnectionService connectionService = new ConnectionService();
        try {
            PreparedStatement statement = connectionService.getDBConnection().
                    prepareStatement("SELECT * FROM devices JOIN factorys " +
                            "ON devices.factory_id = factorys.id WHERE device_id = " + id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            for (int i = 1; i < 11; i++) {
                System.out.print("`" + resultSet.getString(i) + "_");
            }
            statement.close();
            connectionService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeFields(int id) {
        ConnectionService connectionService = new ConnectionService();
        try {
            Statement statement = connectionService.getDBConnection().createStatement();
            statement.executeUpdate("UPDATE devices SET price = '1299'," +
                    " descriptions = 'Its Changed' WHERE device_id = " + id);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM devices JOIN factorys " +
                    "ON devices.factory_id = factorys.id WHERE device_id = " + id);
            resultSet.next();
            for (int i = 1; i < 11; i++) {
                System.out.print("`" + resultSet.getString(i) + "_");
            }
            statement.close();
            connectionService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDevice(int id) {
        ConnectionService connectionService = new ConnectionService();
        try {
            Statement statement = connectionService.getDBConnection().createStatement();
            statement.execute("DELETE FROM devices WHERE device_id = " + id);
            statement.close();
            connectionService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void infoAllDevicesFromFactory(int id) {
        ConnectionService connectionService = new ConnectionService();
        try {
            PreparedStatement statement = connectionService.getDBConnection().
                    prepareStatement("SELECT * FROM factorys JOIN devices " +
                            "ON factorys.id = devices.factory_id WHERE id = " + id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                for (int i = 1; i < 11; i++) {
                    System.out.print("`" + resultSet.getString(i) + "_");
                }
                System.out.println();
            }
            statement.close();
            connectionService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void infoAllDevicesAndSumOfThemFromFactory() {
        ConnectionService connectionService = new ConnectionService();
        try {
            PreparedStatement statement = connectionService.getDBConnection().
                    prepareStatement("SELECT factory_id, SUM(price), COUNT(model) FROM devices GROUP BY factory_id");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                for (int i = 1; i < 4; i++) {
                    System.out.print("`" + resultSet.getString(i) + "_");
                }
                System.out.println();
            }
            statement.close();
            connectionService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}