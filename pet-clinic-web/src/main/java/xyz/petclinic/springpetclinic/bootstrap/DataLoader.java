package xyz.petclinic.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.petclinic.springpetclinic.model.Owner;
import xyz.petclinic.springpetclinic.model.Vet;
import xyz.petclinic.springpetclinic.services.OwnerService;
import xyz.petclinic.springpetclinic.services.VetService;
import xyz.petclinic.springpetclinic.services.map.OwnerServiceMap;
import xyz.petclinic.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o1.setId(2L);
        o1.setFirstName("Jim");
        o1.setLastName("Weston");
        ownerService.save(o2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alan");
        vet2.setLastName("West");
        vetService.save(vet2);
    }
}
