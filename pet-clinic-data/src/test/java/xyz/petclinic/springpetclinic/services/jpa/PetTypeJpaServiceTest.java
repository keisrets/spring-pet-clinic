package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.PetType;
import xyz.petclinic.springpetclinic.repositories.OwnerRepository;
import xyz.petclinic.springpetclinic.repositories.PetRepository;
import xyz.petclinic.springpetclinic.repositories.PetTypeRepository;
import xyz.petclinic.springpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetTypeJpaServiceTest {

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    PetTypeJpaService service;

    PetType type;
    static Set<PetType> types;

    @BeforeAll
    public static void beforeAll() {
        types = new HashSet<>();

        types.add(new PetType());
        types.add(new PetType());
    }

    @BeforeEach
    void setUp() {
        type = new PetType();
        type.setName("Cat");
        type.setId(1L);
    }

    @Test
    void findAll() {
        when(petTypeRepository.findAll()).thenReturn(types);
        Set<PetType> result = service.findAll();

        verify(petTypeRepository).findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        when(petTypeRepository.findById(any())).thenReturn(Optional.of(type));
        PetType result = service.findById(1L);

        verify(petTypeRepository).findById(any());
        assertNotNull(result);
    }

    @Test
    void save() {
        when(petTypeRepository.save(any())).thenReturn(type);
        PetType result = service.save(new PetType());

        verify(petTypeRepository).save(any());
        assertNotNull(result);
    }

    @Test
    void delete() {
        service.delete(type);
        verify(petTypeRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(type.getId());
        verify(petTypeRepository).deleteById(any());
    }
}