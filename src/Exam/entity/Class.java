package Exam.entity;

public class Class {
    private static int nextId = 0;
    private int classId;
    private String className;
    private int teacherId;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherId() {
        return teacherId;
    }


    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Class(String className, int teacherId) {
        this.className = className;
        this.teacherId = teacherId;
        this.classId = nextId++;
    }

    public Class(int classId, String className, int teacherId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
    }
}
