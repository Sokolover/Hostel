package com.company.people;

import com.company.hostel.Floor;
import com.company.hostel.Hostel;
import com.company.hostel.Room;

public class Student {

    private String name;
    private boolean comeToHostel;
    private int rebuke;
    private boolean havePayedHostel;
    private boolean pass;
    private int course;
    private int yearsInHostel;
    private boolean liveInHostel;

    public Student(String name, boolean comeToHostel, int rebuke, boolean havePayedHostel, boolean pass, int course) {
        this.name = name;
        this.comeToHostel = comeToHostel;
        this.rebuke = rebuke;
        this.havePayedHostel = havePayedHostel;
        this.pass = pass;
        this.course = course;
    }

    Student() {

    }

    static public void payHostel(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    student.setPayedHostel((int) (Math.random() * 2) == 1);
                }
            }
        }
        System.out.println("Students PAY for hostel...");
    }

    static public void allPayHostel(Hostel hostel){
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    student.setPayedHostel(true);
                }
            }
        }
        System.out.println("ALL Students PAY for hostel...");
    }

    public void makeRoomDirty(Room room) {
        room.setClean(((int) (Math.random() * 2)) == 1);
    }

    public void showStudent(Student student) {
        System.out.println("\t\tName: " + student.getName());
        System.out.println("\tCourse: " + student.getCourse());
        System.out.println("\tRebukes: " + student.getRebuke());
        System.out.println("\tPayed: " + student.getPayedHostel());
    }

    String showStudent() {
        System.out.println("\t\tName: " + this.getName());
        System.out.println("\tCourse: " + this.getCourse());
        System.out.println("\tRebukes: " + this.getRebuke());
        System.out.println("\tPayed: " + this.getPayedHostel());
        return "";
    }

//    public boolean isLiveInHostel() {
//        return liveInHostel;
//    }
//
//    public void setLiveInHostel(boolean liveInHostel) {
//        this.liveInHostel = liveInHostel;
//    }

    boolean isComeToHostel() {
        return comeToHostel;
    }

    void setComeToHostel(boolean comeToHostel) {
        this.comeToHostel = comeToHostel;
    }

    int getRebuke() {
        return rebuke;
    }

    void setRebuke(int rebuke) {
        this.rebuke = rebuke;
    }

    boolean getPayedHostel() {
        return havePayedHostel;
    }

    void setPayedHostel(boolean havePayedHostel) {
        this.havePayedHostel = havePayedHostel;
    }

    boolean havePass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getYearsInHostel() {
        return yearsInHostel;
    }

    public void setYearsInHostel(int yearsInHostel) {
        this.yearsInHostel = yearsInHostel;
    }
}
