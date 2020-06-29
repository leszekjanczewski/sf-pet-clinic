package pl.robous.sfpetclinic.services;

import pl.robous.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
