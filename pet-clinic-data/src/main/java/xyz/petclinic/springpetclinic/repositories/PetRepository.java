package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
