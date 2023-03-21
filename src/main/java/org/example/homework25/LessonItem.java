package org.example.homework25;

public class LessonItem {
    private final String id;
    private String name;
    private String updatedAt;


    public LessonItem(String id, String name, String updatedAt) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String setDate) {
        this.updatedAt = setDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
