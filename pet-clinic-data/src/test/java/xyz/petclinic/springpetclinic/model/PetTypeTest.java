package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeTest {

    PetType petType;

    @BeforeEach
    public void setUp() {
        petType = new PetType();
        petType.setName("Cat");
    }

    @Test
    void testToString() {
        assertEquals("Cat", petType.toString());
    }

    @Test
    void getName() {
        assertNotNull(petType.getName());
        assertEquals("Cat", petType.getName());
    }

    @Test
    void setName() {
        petType.setName("Dog");
        assertEquals("Dog", petType.getName());
    }
}