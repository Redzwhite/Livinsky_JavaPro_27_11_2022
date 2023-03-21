package org.example.homework25;

import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    //Как безопастно сохранить настройки базы данных в Java?
    // Пробывал сохранить в переменных окружения но не понял как их импортировать при выполнении класса
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}

