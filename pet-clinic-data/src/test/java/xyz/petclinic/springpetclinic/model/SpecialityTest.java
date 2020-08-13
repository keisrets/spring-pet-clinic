package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityTest {

    Speciality speciality;

    @BeforeEach
    public void setUp() {
        speciality = new Speciality();
        speciality.setSpeciality("Surgeon");
    }

    @Test
    void getSpeciality() {
        assertNotNull(speciality.getSpeciality());
        assertEquals("Surgeon", speciality.getSpeciality());
    }

    @Test
    void setSpeciality() {
        speciality.setSpeciality("Pharmacist");
        assertEquals("Pharmacist", speciality.getSpeciality());
    }
}