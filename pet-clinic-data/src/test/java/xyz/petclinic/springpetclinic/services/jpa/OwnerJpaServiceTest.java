package xyz.petclinic.springpetclinic.services.jpa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerJpaService service;

    Owner owner;
    static Set<Owner> owners;

    @BeforeAll
    public static void beforeAll() {
        owners = new HashSet<>();

        owners.add(new Owner());
        owners.add(new Owner());
    }

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Smith");
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner o = service.findByLastName("Aaron");

        assertEquals("Smith", o.getLastName());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownerSet = service.findAll();

        assertNotNull(ownerSet);
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(owner));
        Owner result = service.findById(1L);

        assertNotNull(result);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner result = service.save(new Owner());

        assertNotNull(result);
    }

    @Test
    void delete() {
        service.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(any());
    }
}