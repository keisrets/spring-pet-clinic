package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String name);

    List<Owner> findAllByLastNameLike(String lastName);
}
