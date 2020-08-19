package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
