package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.Visit;
import xyz.petclinic.springpetclinic.repositories.VisitRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitJpaServiceTest {

    @Mock
    VisitRepository repository;

    @InjectMocks
    VisitJpaService service;

    Visit visit;

    @BeforeEach
    void setUp() {
        visit = new Visit();
        visit.setId(1L);
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(new Visit());

        when(repository.findAll()).thenReturn(visitSet);
        Set<Visit> result = service.findAll();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(any())).thenReturn(Optional.of(visit));
        Visit result = service.findById(visit.getId());

        assertNotNull(result);
        verify(repository).findById(any());
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(visit);
        Visit result = service.save(new Visit());

        assertNotNull(result);
        verify(repository).save(any());
    }

    @Test
    void delete() {
        service.delete(visit);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(visit.getId());
        verify(repository).deleteById(any());
    }
}