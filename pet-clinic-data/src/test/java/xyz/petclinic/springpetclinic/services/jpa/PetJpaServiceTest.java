package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.Pet;
import xyz.petclinic.springpetclinic.repositories.PetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetJpaServiceTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    PetJpaService service;

    Pet pet;
    static Set<Pet> pets;

    @BeforeAll
    public static void beforeAll() {
        pets = new HashSet<>();
        pets.add(new Pet());
    }

    @BeforeEach
    public void setUp() {
        pet = new Pet();
        pet.setId(1L);
        pet.setName("Snowball");
    }

    @Test
    void findAll() {
        when(petRepository.findAll()).thenReturn(pets);
        Set<Pet> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void findById() {
        when(petRepository.findById(any())).thenReturn(Optional.of(pet));
        Pet result = service.findById(1L);

        verify(petRepository).findById(any());
        assertNotNull(result);
    }

    @Test
    void save() {
        when(petRepository.save(any())).thenReturn(pet);
        Pet result = service.save(new Pet());

        verify(petRepository).save(any());
        assertNotNull(result);
    }

    @Test
    void delete() {
        service.delete(pet);
        verify(petRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(pet.getId());
        verify(petRepository).deleteById(any());
    }
}