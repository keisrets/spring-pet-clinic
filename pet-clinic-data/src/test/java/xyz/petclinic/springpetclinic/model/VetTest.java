package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {

    Vet vet;
    static Speciality speciality;
    static Set<Speciality> specialities;

    @BeforeAll
    public static void beforeSetUp() {
        speciality = new Speciality();
        speciality.setSpeciality("Pharmacist");

        specialities = new HashSet<>();
        specialities.add(speciality);
    }

    @BeforeEach
    public void setUp() {
        vet = new Vet();
    }

    @Test
    void getSpecialities() {
        assertEquals(0, vet.getSpecialities().size());

        vet.getSpecialities().add(speciality);
        assertEquals(1, vet.getSpecialities().size());
    }

    @Test
    void setSpecialities() {
        vet.setSpecialities(specialities);

        assertEquals(1, vet.getSpecialities().size());
        assertEquals(specialities, vet.getSpecialities());
    }
}