package com.company.constants;

public enum Constant {
    FLOORS_IN_HOSTEL(1),
    ROOMS_ON_FLOOR(2),
    STUDENTS_IN_ROOM(3),
    COURSES_NUMBER(4),
    MAX_REBUKES(2),
    MIN_COURSE(2),
    YEAR_LENGTH(1),
    YEAR_NUMBER(1);

    private int value;

    Constant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
