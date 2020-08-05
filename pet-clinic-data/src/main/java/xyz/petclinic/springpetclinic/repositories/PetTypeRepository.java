package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
