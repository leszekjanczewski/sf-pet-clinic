package pl.robous.sfpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robous.sfpetclinic.model.*;
import pl.robous.sfpetclinic.services.OwnerService;
import pl.robous.sfpetclinic.services.PetTypeService;
import pl.robous.sfpetclinic.services.SpecialityService;
import pl.robous.sfpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialityService.save(radiology);
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michel");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDay(LocalDate.now());
        fionasCat.setPetType(saveCatPetType);
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("San");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jim");
        vet2.setLastName("Morris");
        vet2.getSpecialities().add(saveSurgery);
        vet2.getSpecialities().add(saveDentistry);
        vetService.save(vet2);
    }
}
