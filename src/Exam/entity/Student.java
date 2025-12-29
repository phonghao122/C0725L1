package Exam.entity;

import java.time.LocalDate;

public class Student extends Person {
    private int classID;


    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public Student(String name, String dob, String gender, String phone, int classID) {
        super(name,dob,gender,phone);
        this.classID = classID;
    }

    public Student(int id, String name, String dob, String gender, String phone, int classID) {
        super(id,name,dob,gender,phone);
        this.classID = classID;
    }
}
