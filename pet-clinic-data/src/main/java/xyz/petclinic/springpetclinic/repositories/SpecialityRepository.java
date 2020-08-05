package xyz.petclinic.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.petclinic.springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
