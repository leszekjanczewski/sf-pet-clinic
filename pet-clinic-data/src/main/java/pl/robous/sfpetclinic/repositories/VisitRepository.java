package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
