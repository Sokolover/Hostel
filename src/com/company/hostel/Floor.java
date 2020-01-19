package com.company.hostel;

import com.company.people.Headman;
import com.company.constants.Constant;

import java.util.ArrayList;
import java.util.List;


public class Floor{

    private List<Room> rooms = new ArrayList<>(Constant.ROOMS_ON_FLOOR.getValue());
    private Headman headman;
    private int number;

    Floor(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Floor() {

    }

    void showFloors(Floor floor){
        for (Room room : this.rooms){
            room.showRoom(room);
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Headman getHeadman() {
        return headman;
    }

    public void setHeadman(Headman headman) {
        this.headman = headman;
    }

    public int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }
}
