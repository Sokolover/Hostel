package com.company.people;

import com.company.attributes.Administration;
import com.company.constants.Constant;
import com.company.constants.Name;
import com.company.hostel.Floor;
import com.company.hostel.Hostel;
import com.company.hostel.Room;

import java.util.List;

public class Commandant implements Administration {

    private boolean evictOne(Room room) {
        for (Student student : room.getStudents()) {
            if (student.getCourse() > Constant.COURSES_NUMBER.getValue() ||
                    student.getRebuke() > Constant.MAX_REBUKES.getValue() ||
                    !student.getPayedHostel()) {
                System.out.println("Student " + student.showStudent() + " has been evicted");
                room.getStudents().remove(student);
                return true;
            }
        }
        return false;
    }

    public void evictAll(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                while (evictOne(room)) ;
            }
        }
        System.out.println("\nStudents have been evicted from hostel!");
    }

    private void checkIn(Room room) {
        List<String> names = Name.names;
        for (int i = 0; i < Constant.STUDENTS_IN_ROOM.getValue(); i++) {
            int index = (int) (Math.random() * names.size());
            int course = (int) (Math.random() * 4) + 1;
            String name = names.get(index);
            Student student = new Student(name, true, 0, false, true, course);
            room.getStudents().add(student);
        }
    }

    public void checkInAll(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                if (room.getStudents().size() < Constant.STUDENTS_IN_ROOM.getValue()) {
                    checkIn(room);
                }
            }
        }
        System.out.println("Students have been checked in");
    }
}


