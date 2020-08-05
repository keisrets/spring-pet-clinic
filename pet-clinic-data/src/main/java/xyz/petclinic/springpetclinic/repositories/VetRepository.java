package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
