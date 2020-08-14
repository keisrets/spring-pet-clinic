package xyz.petclinic.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.petclinic.springpetclinic.model.Speciality;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpecialityMapServiceTest {

    SpecialityMapService service;
    Speciality spec;

    @BeforeEach
    void setUp() {
        service = new SpecialityMapService();
        spec = new Speciality();
        spec.setId(1L);
        service.save(spec);
    }

    @Test
    void findAll() {
        Set<Speciality> results = service.findAll();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void findById() {
        Speciality result = service.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void save() {
        Speciality result = service.save(new Speciality());
        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete() {
        service.delete(spec);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(spec.getId());
        assertEquals(0, service.findAll().size());
    }
}