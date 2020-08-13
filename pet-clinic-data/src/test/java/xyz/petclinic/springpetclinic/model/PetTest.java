package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;
    static PetType type;
    static Visit visit;
    static Set<Visit> visits;
    static LocalDate date;
    static Owner owner;

    @BeforeAll
    public static void initializeObjects() {
        type = new PetType(1L, "Cat");

        visit = new Visit();
        visit.setDescription("X-ray");

        visits = new HashSet<>();
        visits.add(visit);
        date = LocalDate.now();

        owner = new Owner();
        owner.setFirstName("John");
    }

    @BeforeEach
    public void setUp() {
        pet = new Pet();
    }

    @Test
    void getName() {
        assertNull(pet.getName());

        pet.setName("Rex");
        assertEquals("Rex", pet.getName());
    }

    @Test
    void getPetType() {
        assertNull(pet.getPetType());

        pet.setPetType(type);

        assertNotNull(pet.getPetType());
        assertEquals("Cat", pet.getPetType().getName());
    }

    @Test
    void getOwner() {
        assertNull(pet.getOwner());

        pet.setOwner(owner);

        assertNotNull(pet.getOwner());
        assertEquals("John", pet.getOwner().getFirstName());
    }

    @Test
    void getBirthDate() {
        assertNull(pet.getBirthDate());

        pet.setBirthDate(date);
        assertNotNull(pet.getBirthDate());
        assertEquals(date, pet.getBirthDate());
    }

    @Test
    void getVisits() {
        assertEquals(0, pet.getVisits().size());

        visits.add(visit);
        pet.setVisits(visits);

        assertNotNull(pet.getVisits());
        assertEquals(1, pet.getVisits().size());
    }

    @Test
    void setName() {
        pet.setName("Rex");

        assertEquals("Rex", pet.getName());
    }

    @Test
    void setPetType() {
        pet.setPetType(type);

        assertNotNull(pet.getPetType());
        assertEquals("Cat", pet.getPetType().getName());
    }

    @Test
    void setOwner() {
        pet.setOwner(owner);

        assertNotNull(pet.getOwner());
        assertEquals("John", pet.getOwner().getFirstName());
    }

    @Test
    void setBirthDate() {
        pet.setBirthDate(date);

        assertNotNull(pet.getBirthDate());
        assertEquals(date.toString(), pet.getBirthDate().toString());
    }

    @Test
    void setVisits() {
        assertEquals(0, pet.getVisits().size());
        pet.setVisits(visits);

        assertEquals(1, pet.getVisits().size());
    }
}