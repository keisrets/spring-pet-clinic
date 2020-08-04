package xyz.petclinic.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.model.PetType;
import xyz.petclinic.springpetclinic.model.Vet;
import xyz.petclinic.springpetclinic.services.OwnerService;
import xyz.petclinic.springpetclinic.services.PetTypeService;
import xyz.petclinic.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType t1 = new PetType();
        t1.setName("dog");
        PetType saveDogPetType = petTypeService.save(t1);

        PetType t2 = new PetType();
        t2.setName("cat");
        PetType saveCatPetType = petTypeService.save(t2);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Jim");
        o2.setLastName("Weston");
        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Andrew");
        o3.setLastName("Weston");
        ownerService.save(o3);

        Owner o4 = new Owner();
        o4.setFirstName("John");
        o4.setLastName("Weston");
        ownerService.save(o4);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alan");
        vet2.setLastName("West");
        vetService.save(vet2);
    }
}
