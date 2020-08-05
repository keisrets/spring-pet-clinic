package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
