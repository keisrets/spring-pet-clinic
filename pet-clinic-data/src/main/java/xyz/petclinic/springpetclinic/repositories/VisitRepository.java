package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
