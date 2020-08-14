package xyz.petclinic.springpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.petclinic.springpetclinic.model.PetType;
import xyz.petclinic.springpetclinic.services.OwnerService;
import xyz.petclinic.springpetclinic.services.PetService;
import xyz.petclinic.springpetclinic.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

    @Mock
    PetService petService;
    @Mock
    OwnerService ownerService;
    @Mock
    PetTypeService petTypeService;

    @InjectMocks
    PetController petController;

    MockMvc mockMvc;

    Set<PetType> pets;

    @BeforeEach
    void setUp() {
        pets = new HashSet<>();
        pets.add(new PetType());

        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void populatePetTypes() {
    }

    @Test
    void findOwner() {
    }

    @Test
    void initOwnerBinder() {
    }

    @Test
    void initCreationForm() {

    }

    @Test
    void processCreationForm() {
    }
}