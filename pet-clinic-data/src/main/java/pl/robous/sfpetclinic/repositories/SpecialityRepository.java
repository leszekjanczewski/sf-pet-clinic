package pl.robous.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.robous.sfpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
