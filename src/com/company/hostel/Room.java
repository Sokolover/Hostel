package com.company.hostel;

import com.company.people.Student;
import com.company.constants.Constant;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private List<Student> students = new ArrayList<>(Constant.STUDENTS_IN_ROOM.getValue());
    private boolean clean;
    private int number;

    public Room() {

    }

    void showRoom(Room room) {
        System.out.println("Room №" + this.getNumber() + " :");
        for (Student student : this.students){
            student.showStudent(student);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    void setStudents(List<Student> students) {
        this.students = students;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }
}
