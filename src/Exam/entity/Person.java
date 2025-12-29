package Exam.entity;

import java.time.LocalDate;

public class Person {
    private static int nextId = 0;
    private int id;
    private String name;
    private String dob;
    private String gender;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Person(String name, String dob, String gender, String phone) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.id = nextId++;
    }

    public Person(int id, String name, String dob, String gender, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
    }
}
