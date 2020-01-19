package com.company.people;

import com.company.attributes.Administration;
import com.company.hostel.Floor;
import com.company.hostel.Hostel;
import com.company.hostel.Room;

public class Guard implements Administration {

    public void checkPassCards(Hostel hostel){
        for (Floor floor : hostel.getFloors()) {
            for (Room room : floor.getRooms()) {
                for (Student student : room.getStudents()) {
                    letIn(student);
                    if(!student.isComeToHostel()){
                        System.out.println("Student " + student.getName() + " is permitted to come in hostel");
                    }
                }
            }
        }
    }

    private void letIn(Student student) {
        if (student.havePass()) {
            student.setComeToHostel(true);
        } else {
            student.setComeToHostel(false);
        }
    }
}
