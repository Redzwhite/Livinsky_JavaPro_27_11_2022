package org.example.homework25;

import java.sql.*;

public class HomeworkDao {
    private final Connection connection;

    public HomeworkDao() throws SQLException {
        this.connection = DataBaseConnection.getConnection();
    }

    public void addHomeWork(Homework homework) throws SQLException {
        String query = "INSERT INTO Homework (name, description) VALUES (?, ?);";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, homework.getName());
        statement.setString(2, homework.getDescription());
        statement.executeUpdate();
        statement.close();
    }

    public HomeworkItem getLatestHomeworkByName(String name) throws SQLException {
        String query = "SELECT h.id, h.name, h.description " +
                "FROM Homework h " +
                "WHERE h.name = ? ORDER BY h.id DESC LIMIT 1;";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        HomeworkItem homework = null;

        if (resultSet.next()) {
            String hId = resultSet.getString(1);
            String homeworkName = resultSet.getString(2);
            String homeworkDescription = resultSet.getString(3);
            homework = new HomeworkItem(hId, homeworkName, homeworkDescription);
        }

        resultSet.close();
        statement.close();

        return homework;
    }
}
