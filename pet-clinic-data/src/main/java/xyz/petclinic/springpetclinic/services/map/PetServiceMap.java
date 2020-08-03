package xyz.petclinic.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import xyz.petclinic.springpetclinic.model.Pet;
import xyz.petclinic.springpetclinic.services.CrudService;
import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}