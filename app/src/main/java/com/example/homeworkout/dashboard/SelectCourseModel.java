package com.example.homeworkout.dashboard;

public class SelectCourseModel {
    int courseImage;
    String courseName;

    public SelectCourseModel(int courseImage, String courseName) {
        this.courseImage = courseImage;
        this.courseName = courseName;
    }

    public int getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(int courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
