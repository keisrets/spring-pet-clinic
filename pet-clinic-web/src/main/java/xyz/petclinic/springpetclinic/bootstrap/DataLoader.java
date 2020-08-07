package xyz.petclinic.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.petclinic.springpetclinic.model.*;
import xyz.petclinic.springpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            load();
        }
    }

    private void load() {
        PetType t1 = new PetType();
        t1.setName("Dog");
        PetType saveDogPetType = petTypeService.save(t1);

        PetType t2 = new PetType();
        t2.setName("Cat");
        PetType saveCatPetType = petTypeService.save(t2);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        o1.setAddress("123 Sesame Street");
        o1.setCity("AAA");
        o1.setTelephone("123345678");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(o1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rex");
        o1.getPets().add(mikesPet);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Jim");
        o2.setLastName("Weston");
        o2.setAddress("321 Sesame Street");
        o2.setCity("AAA");
        o2.setTelephone("123345678");
        Pet fionasCat = new Pet();
        fionasCat.setPetType(saveCatPetType);
        fionasCat.setOwner(o2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Snowball");
        o2.getPets().add(fionasCat);
        ownerService.save(o2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("X-ray");
        visitService.save(catVisit);

        Owner o3 = new Owner();
        o3.setFirstName("Andrew");
        o3.setLastName("Weston");
        o3.setAddress("1 Sesame Street");
        o3.setCity("AAA");
        o3.setTelephone("123345678");
        ownerService.save(o3);

        Owner o4 = new Owner();
        o4.setFirstName("John");
        o4.setLastName("Weston");
        o4.setAddress("123 Sesame Street");
        o4.setCity("AAA");
        o4.setTelephone("123345678");
        ownerService.save(o4);

        Speciality radiology = new Speciality();
        radiology.setSpeciality("Radiology");
        Speciality savedSpec = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setSpeciality("Surgery");
        Speciality savedSpec1 = specialityService.save(radiology);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSpec);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alan");
        vet2.setLastName("West");
        vet2.getSpecialities().add(savedSpec1);
        vetService.save(vet2);
    }
}
