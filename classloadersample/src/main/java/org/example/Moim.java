package org.example;

public class Moim {
    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean inEnrollmentFull(){
        if (maxNumberOfAttendees == 0){
            return false;
        }

        if (numberOfEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
