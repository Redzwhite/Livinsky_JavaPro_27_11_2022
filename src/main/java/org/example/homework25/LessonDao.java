package org.example.homework25;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private final Connection connection;

    public LessonDao() throws SQLException {
        this.connection = DataBaseConnection.getConnection();
    }

    public void addLesson(Lesson lesson) throws SQLException, NumberFormatException {
        String query = "INSERT INTO Lesson (name, updatedAt, homework_id) VALUES (?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lesson.getName());
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.setInt(3, Integer.parseInt(lesson.getHomework().getId()));
            statement.executeUpdate();
        }
    }

    public void deleteLesson(int lessonId) throws SQLException {
        String query = "DELETE FROM Lesson WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        }
    }

    public List<LessonItem> getAllLessons() throws SQLException {
        String query = "SELECT l.id, l.name, l.updatedAt " +
                "FROM Lesson l;";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            List<LessonItem> lessons = new ArrayList<>();

            while (resultSet.next()) {
                String lessonId = resultSet.getString(1);
                String lessonName = resultSet.getString(2);
                String lessonUpdatedAt = resultSet.getString(3);
                LessonItem lesson = new LessonItem(lessonId, lessonName, lessonUpdatedAt);
                lessons.add(lesson);
            }

            return lessons;
        }
    }

    public LessonItem getLessonById(int lessonId) throws SQLException {
        String query = "SELECT l.id, l.name, l.updatedAt " +
                "FROM Lesson l " +
                "WHERE l.id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                LessonItem lesson = null;
                if (resultSet.next()) {
                    String lId = resultSet.getString(1);
                    String lessonName = resultSet.getString(2);
                    String lessonUpdatedAt = resultSet.getString(3);
                    lesson = new LessonItem(lId, lessonName, lessonUpdatedAt);
                }
                return lesson;
            }
        }
    }
}
