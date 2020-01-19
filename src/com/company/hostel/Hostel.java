package com.company.hostel;

import com.company.people.Commandant;
import com.company.people.Guard;
import com.company.people.Headman;
import com.company.people.Student;
import com.company.constants.Constant;

import java.util.ArrayList;
import java.util.List;

public class Hostel {

    private List<Floor> floors = new ArrayList<>(Constant.FLOORS_IN_HOSTEL.getValue());
    private Guard guard;
    private Commandant commandant;

    public Hostel() {

        List<Floor> floors = new ArrayList<>(Constant.FLOORS_IN_HOSTEL.getValue());

        String[] names = {"Clara", "Bob", "Jim", "Kent", "Raven", "Asalia", "Rian", "Andrew", "Discord", "Skype",
                "Marina", "Alexander", "Bread", "Lanselot", "Petrify", "Rot", "Spoil", "Festerr"};

        int floorNumber = 100;

        for (int i = 0; i < Constant.FLOORS_IN_HOSTEL.getValue(); i++) {

            List<Room> rooms = new ArrayList<>();

            for (int j = 0; j < Constant.ROOMS_ON_FLOOR.getValue(); j++) {
                rooms.add(new Room());
            }

            int roomNumber = 0;

            for (Room room : rooms) {
                //boolean pass = ((int) (Math.random() * 2)) == 1;

                List<Student> students = new ArrayList<>();

                for (int j = 0; j < Constant.STUDENTS_IN_ROOM.getValue(); j++) {
                    students.add(new Student(names[(int) (Math.random() * names.length)], true,
                            0, false, true, (int) (Math.random() * 4) + 1));
                }

                roomNumber++;
                room.setNumber(floorNumber + roomNumber);
                room.setStudents(students);
                room.setClean(true);
            }

            floorNumber += 100;

            Floor floor = new Floor(rooms);

            floor.setNumber(i + 1);

            electHeadman(floor);

            floors.add(floor);
        }

        Guard guard = new Guard();
        Commandant commandant = new Commandant();

        this.setFloors(floors);
        this.setCommandant(commandant);
        this.setGuard(guard);
    }


    private void electHeadman(Floor floor) {
        if(!(floor.getHeadman() == null)){
            System.out.println("Headman already exists");
            return;
        }
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

    public void showHostel() {
        for (Floor floor : this.floors) {
            floor.showFloors(floor);
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    private void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public Guard getGuard() {
        return guard;
    }

    private void setGuard(Guard guard) {
        this.guard = guard;
    }

    public Commandant getCommandant() {
        return commandant;
    }

    private void setCommandant(Commandant commandant) {
        this.commandant = commandant;
    }
}
