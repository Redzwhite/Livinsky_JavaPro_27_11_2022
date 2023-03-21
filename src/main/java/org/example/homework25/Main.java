package org.example.homework25;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            LessonDao dao = new LessonDao();
            HomeworkDao hdao = new HomeworkDao();

            // додавання уроку
            Homework homework = new Homework("Homework 1", "Description 1");
            hdao.addHomeWork(homework);
            HomeworkItem latestHomework = hdao.getLatestHomeworkByName(homework.getName());
            Lesson lesson = new Lesson("Lesson 1", new Date(), latestHomework);
            dao.addLesson(lesson);


            // отримання всіх уроків
            List<LessonItem> lessons = dao.getAllLessons();

            // отримання уроку за ID
            LessonItem lessonById = dao.getLessonById(1);

            // видалення уроку
            dao.deleteLesson(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
