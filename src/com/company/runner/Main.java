package com.company.runner;

import com.company.constants.Constant;
import com.company.hostel.Floor;
import com.company.hostel.Hostel;
import com.company.hostel.Room;
import com.company.people.Headman;
import com.company.people.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Number of floors in the hostel: ");
        int floorsNumber = getValue();
        Constant.FLOORS_IN_HOSTEL.setValue(floorsNumber);
        System.out.print("Number of rooms on the floor: ");
        int roomsOnFloor = getValue();
        Constant.ROOMS_ON_FLOOR.setValue(roomsOnFloor);
        System.out.print("Number of students in the room: ");
        int studentsInRoom = getValue();
        Constant.STUDENTS_IN_ROOM.setValue(studentsInRoom);

        Hostel hostel = new Hostel();

        Main go = new Main();

        go.action(hostel);
    }

    private void action(Hostel hostel) {
        for (int j = 0; j < Constant.YEAR_NUMBER.getValue(); j++) {

            hostel.getCommandant().checkInAll(hostel);
            electHeadman(hostel);

            for (int i = 0; i < Constant.YEAR_LENGTH.getValue(); i++) {

                hostel.showHostel();

                eventMakeRoomDirty(hostel);
                headmanCheck(hostel);

                System.out.println("\nnow think about CLEANING ROOMS\n");

                eventStudentsCleanAllRooms(hostel);
                headmanCheck(hostel);

                System.out.println("\nnow think about passing people in hostel\n");

                eventStudentsPassCards(hostel);
                hostel.getGuard().checkPassCards(hostel);

                Student.payHostel(hostel);
            }
            nextYear(hostel);
            hostel.showHostel();
            System.out.println("\n");
            hostel.getCommandant().evictAll(hostel);
            System.out.println("\n");
            hostel.showHostel();
        }
    }

    private static int getValue() {
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();
        while (value <= 0) {
            System.out.print("Invalid value! Try again: ");
            scanner.nextLine();
            value = scanner.nextInt();
        }

        return value;
    }

    private void electHeadman(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            if (floor.getHeadman() == null) {
                chooseOne(floor);
            }
        }
        System.out.println("Headman has been elected on all floors");
    }

    private void chooseOne(Floor floor) {
        for (Room room : floor.getRooms()) {
            for (Student student : room.getStudents()) {
                if (student.getYearsInHostel() >= Constant.MIN_COURSE.getValue()) {
                    Headman headman = new Headman(student);
                    room.getStudents().remove(student);
                    room.getStudents().add(headman);
                    floor.setHeadman(headman);
                    return;
                }
            }
        }
        for (Room room : floor.getRooms()) {
            for (Student student : room.getStudents()) {
                if (student.getCourse() >= Constant.MIN_COURSE.getValue()) {
                    Headman headman = new Headman(student);
                    room.getStudents().remove(student);
                    room.getStudents().add(headman);
                    floor.setHeadman(headman);
                    return;
                }
            }
        }
        for (Room room : floor.getRooms()) {
            for (Student student : room.getStudents()) {
                Headman headman = new Headman(student);
                room.getStudents().remove(student);
                room.getStudents().add(headman);
                floor.setHeadman(headman);
                return;
            }
        }
    }

    private void eventStudentsPassCards(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    student.setPass(((int) (Math.random() * 2)) == 1);
                }
            }
        }
        System.out.println("Students MAY drop their passes :-(");
    }

    private void headmanCheck(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            floor.getHeadman().checkRooms(floor);
        }
    }

    private void eventStudentsCleanAllRooms(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                room.setClean(true);
            }
        }
        System.out.println("Students CAN clean all rooms!");
    }

    private void eventMakeRoomDirty(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    student.makeRoomDirty(room);
                }
            }
        }
        System.out.println("Sometimes students makes their rooms dirty...");
    }

    private void nextYear(Hostel hostel) {
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    student.setCourse(student.getCourse() + 1);
                    student.setYearsInHostel(student.getYearsInHostel() + 1);
                }
            }
        }
        System.out.println("Next year is coming...");
    }
}
