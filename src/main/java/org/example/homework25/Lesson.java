package org.example.homework25;

import java.util.Date;

public class Lesson {
    private int id;
    private String name;

    private Date updatedAt;
    private HomeworkItem homework;

    public Lesson(String name, Date updatedAt, HomeworkItem homework) {
        this.name = name;
        this.updatedAt = updatedAt;
        this.homework = homework;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date setDate) {
        this.updatedAt = setDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HomeworkItem getHomework() {
        return homework;
    }

    public void setHomework(HomeworkItem homework) {
        this.homework = homework;
    }
}
