package xyz.petclinic.springpetclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
    }

    @Test
    void getAddress() {
        assertNull(owner.getAddress());

        owner.setAddress("123 Sesame Street");
        assertEquals("123 Sesame Street", owner.getAddress());
    }

    @Test
    void getCity() {
        assertNull(owner.getCity());

        owner.setCity("Riga");
        assertEquals("Riga", owner.getCity());
    }

    @Test
    void getTelephone() {
        assertNull(owner.getTelephone());

        owner.setTelephone("+37122424629");
        assertEquals("+37122424629", owner.getTelephone());
    }

    @Test
    void getPets() {
        assertNotNull(owner.getPets());
        assertEquals(0, owner.getPets().size());

        owner.getPets().add(new Pet());
        assertEquals(1, owner.getPets().size());
    }

    @Test
    void setAddress() {
        owner.setAddress("Brivibas 21");
        assertEquals("Brivibas 21", owner.getAddress());
    }

    @Test
    void setCity() {
        owner.setCity("Riga");
        assertEquals("Riga", owner.getCity());
    }

    @Test
    void setTelephone() {
        owner.setTelephone("123456");
        assertEquals("123456", owner.getTelephone());
    }

    @Test
    void setPets() {
        Set<Pet> pets = new HashSet<>();
        pets.add(new Pet());

        owner.setPets(pets);
        assertEquals(pets, owner.getPets());
    }
}