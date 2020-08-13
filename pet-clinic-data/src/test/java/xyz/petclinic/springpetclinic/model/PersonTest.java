package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2;

    @BeforeEach
    public void setUp() {
        p1 = new Person();
        p1.setFirstName("John");
        p1.setLastName("Doe");

        p2 = new Person();
    }

    @Test
    void getFirstName() {
        assertEquals("John", p1.getFirstName());
        assertNull(p2.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Doe", p1.getLastName());
        assertNull(p2.getLastName());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Jack");
        p2.setFirstName("Jane");

        assertEquals("Jack", p1.getFirstName());
        assertNotNull(p2.getFirstName());
        assertEquals("Jane", p2.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Tree");
        p2.setLastName("Sun");

        assertEquals("Tree", p1.getLastName());
        assertNotNull(p2.getLastName());
        assertEquals("Sun", p2.getLastName());
    }
}