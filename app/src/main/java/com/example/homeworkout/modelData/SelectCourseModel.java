package com.example.homeworkout.modelData;

public class SelectCourseModel {
    int courseID;
    int courseImage;
    String courseName;
    String courseDesc;

    public SelectCourseModel(int courseID, int courseImage, String courseName, String courseDesc) {
        this.courseID = courseID;
        this.courseImage = courseImage;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
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

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
}
