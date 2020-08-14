package xyz.petclinic.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.petclinic.springpetclinic.model.PetType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeMapServiceTest {

    PetTypeMapService service;
    PetType type;

    @BeforeEach
    void setUp() {
        service = new PetTypeMapService();
        type = new PetType();
        type.setId(1L);
        service.save(type);
    }

    @Test
    void findAll() {
        Set<PetType> results = service.findAll();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void findById() {
        PetType result = service.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void save() {
        PetType result = service.save(new PetType());
        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete() {
        service.delete(type);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(type.getId());
        assertEquals(0, service.findAll().size());
    }
}