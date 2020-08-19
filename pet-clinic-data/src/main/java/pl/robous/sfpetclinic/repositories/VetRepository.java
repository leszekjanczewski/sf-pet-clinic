package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
