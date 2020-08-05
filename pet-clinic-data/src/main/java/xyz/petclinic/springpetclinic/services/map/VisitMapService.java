package xyz.petclinic.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import xyz.petclinic.springpetclinic.model.Visit;
import xyz.petclinic.springpetclinic.repositories.VisitRepository;
import xyz.petclinic.springpetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit object) {
        if(object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getOwner().getId() == null)
        throw new RuntimeException("Invalid visit");

        return super.save(object);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
