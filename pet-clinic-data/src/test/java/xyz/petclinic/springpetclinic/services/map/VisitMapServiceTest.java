package xyz.petclinic.springpetclinic.services.map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.model.Pet;
import xyz.petclinic.springpetclinic.model.PetType;
import xyz.petclinic.springpetclinic.model.Visit;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VisitMapServiceTest {

    VisitMapService visitMapService;
    OwnerMapService ownerMapService;
    PetMapService petMapService;

    Visit visit;
    Owner o;
    Pet p;
    PetType t;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        petMapService = new PetMapService();

        Pet pet = new Pet();
        pet.setId(1L);

        PetType type = new PetType();
        type.setName("Cat");

        Owner owner = new Owner();
        owner.setId(1L);
        owner.getPets().add(pet);
        pet.setOwner(owner);
        pet.setPetType(type);


        petMapService.save(pet);
        ownerMapService.save(owner);

        visit = new Visit();
        visit.setId(1L);
        visit.setPet(pet);
        visitMapService.save(visit);
    }

    @Test
    void findAll() {
        Set<Visit> results = visitMapService.findAll();
        assertNotNull(results);
        assertEquals(1, results.size());
    }

    @Test
    void findById() {
        Visit result = visitMapService.findById(visit.getId());
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void save() {
        o = new Owner();
        o.setId(1L);

        p = new Pet();
        p.setId(1L);

        t = new PetType();
        t.setName("Cat");

        o.getPets().add(p);
        p.setOwner(o);
        p.setPetType(t);

        petMapService.save(p);
        ownerMapService.save(o);

        Visit toSave = Visit.builder().pet(p).build();
        Visit result = visitMapService.save(toSave);

        assertNotNull(result);
        assertEquals(2L, result.getId());
    }

    @Test
    void delete() {
        visitMapService.delete(visit);
        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visit.getId());
        assertEquals(0, visitMapService.findAll().size());
    }
}