package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.Speciality;
import xyz.petclinic.springpetclinic.repositories.SpecialityRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialityJpaServiceTest {

    @Mock
    SpecialityRepository repository;

    @InjectMocks
    SpecialityJpaService service;

    Speciality speciality;
    static Set<Speciality> specialities;

    @BeforeAll
    public static void beforeAll() {
        specialities = new HashSet<>();
        specialities.add(new Speciality());
        specialities.add(new Speciality());
    }

    @BeforeEach
    void setUp() {
        speciality = new Speciality();
        speciality.setId(1L);
        speciality.setSpeciality("Surgeon");
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(specialities);
        Set<Speciality> result = service.findAll();

        verify(repository).findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        when(repository.findById(any())).thenReturn(Optional.of(speciality));
        Speciality result = service.findById(1L);

        verify(repository).findById(any());
        assertNotNull(result);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(speciality);
        Speciality result = service.save(new Speciality());

        verify(repository).save(any());
        assertNotNull(result);
    }

    @Test
    void delete() {
        service.delete(speciality);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(speciality.getId());
        verify(repository).deleteById(any());
    }
}