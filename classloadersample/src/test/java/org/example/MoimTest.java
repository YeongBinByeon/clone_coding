package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoimTest {

    @Test
    public void isFull(){
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;
        Assert.assertFalse(moim.inEnrollmentFull());
    }
}