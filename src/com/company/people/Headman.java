package com.company.people;

import com.company.attributes.Administration;
import com.company.hostel.Floor;
import com.company.hostel.Room;

public class Headman extends Student implements Administration {

    public Headman(Student student) {
        this.setName(student.getName());
        this.setComeToHostel(student.isComeToHostel());
        this.setRebuke(student.getRebuke());
        this.setPayedHostel(student.getPayedHostel());
        this.setPass(student.havePass());
        this.setCourse(student.getCourse());
    }

    private void checkRoom(Room room) {
        if (!room.isClean()) {
            System.out.println("Room №" + room.getNumber());
            for (Student student : room.getStudents()) {
                student.setRebuke(student.getRebuke() + 1);
                System.out.println("\tStudent " + student.getName() + " get rebuke!");
                System.out.println("He has " + student.getRebuke() + " rebukes");
            }
        }
    }

    public void checkRooms(Floor floor) {
        System.out.println("Headman is checking rooms of floor №" + floor.getNumber());
        for (Room room : floor.getRooms()) {
            checkRoom(room);
        }
        System.out.println("Headman have been checked rooms of floor №" + floor.getNumber());
    }

}
