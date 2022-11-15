package com.example.homeworkout.dashboard;

public class SelectCourseModel {
    int courseID;
    int courseImage;
    String courseName;

    public SelectCourseModel(int courseID, int courseImage, String courseName) {
        this.courseID = courseID;
        this.courseImage = courseImage;
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
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
