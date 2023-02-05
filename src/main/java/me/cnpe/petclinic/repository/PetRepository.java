package me.cnpe.petclinic.repository;

import me.cnpe.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

  List<Pet> findByName(String name);
}
