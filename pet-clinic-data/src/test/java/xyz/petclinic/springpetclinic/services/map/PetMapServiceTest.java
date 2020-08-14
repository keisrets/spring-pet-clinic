package xyz.petclinic.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.petclinic.springpetclinic.model.Pet;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    PetMapService service;

    Pet pet;
    final Long id = 1L;

    @BeforeEach
    void setUp() {
        service = new PetMapService();
        pet = new Pet();
        pet.setId(id);
        service.save(pet);
    }

    @Test
    void findAll() {
        Set<Pet> results = service.findAll();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void findById() {
        Pet result = service.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void save() {
        Pet result = service.save(new Pet());
        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete() {
        service.delete(pet);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        assertEquals(0, service.findAll().size());
    }
}