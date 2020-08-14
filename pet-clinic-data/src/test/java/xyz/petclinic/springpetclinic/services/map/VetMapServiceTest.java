package xyz.petclinic.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.petclinic.springpetclinic.model.Vet;
import xyz.petclinic.springpetclinic.services.SpecialityService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetMapServiceTest {

    VetMapService service;
    Vet vet;

    @BeforeEach
    void setUp() {
        service = new VetMapService(new SpecialityMapService());
        vet = new Vet();
        vet.setId(1L);
        service.save(vet);
    }

    @Test
    void findAll() {
        Set<Vet> results = service.findAll();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void findById() {
        Vet result = service.findById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void save() {
        Vet result = service.save(new Vet());
        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete() {
        service.delete(vet);
        assertEquals(0, service.findAll().size());
    }

    @Test
    void deleteById() {
        service.deleteById(vet.getId());
        assertEquals(0, service.findAll().size());
    }
}