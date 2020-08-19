package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
