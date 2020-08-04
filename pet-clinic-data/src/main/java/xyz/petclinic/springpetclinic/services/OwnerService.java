package xyz.petclinic.springpetclinic.services;

import xyz.petclinic.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
