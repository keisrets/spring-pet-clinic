package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.Vet;
import xyz.petclinic.springpetclinic.repositories.VetRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VetJpaServiceTest {

    @Mock
    VetRepository repository;

    @InjectMocks
    VetJpaService service;

    Vet vet;
    static Set<Vet> vets;

    @BeforeAll
    public static void beforeAll() {
        vets = new HashSet<>();
        vets.add(new Vet());
        vets.add(new Vet());
    }

    @BeforeEach
    void setUp() {
        vet = new Vet();
        vet.setId(1L);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(vets);
        Set<Vet> result = service.findAll();

        verify(repository).findAll();
        assertEquals(2, result.size());
    }

    @Test
    void findById() {
        when(repository.findById(any())).thenReturn(Optional.of(vet));
        Vet result = service.findById(vet.getId());

        verify(repository).findById(any());
        assertNotNull(result);
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(vet);
        Vet result = service.save(new Vet());

        verify(repository).save(any());
        assertNotNull(result);
}

    @Test
    void delete() {
        service.delete(vet);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(vet.getId());
        verify(repository).deleteById(any());
    }
}