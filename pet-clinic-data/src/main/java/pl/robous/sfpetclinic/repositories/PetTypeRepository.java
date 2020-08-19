package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
