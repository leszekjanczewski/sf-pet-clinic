package pl.robous.sfpetclinic.services;

import pl.robous.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();

}
