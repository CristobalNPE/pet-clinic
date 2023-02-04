package me.cnpe.petclinic.repository;

import me.cnpe.petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

  Optional<Pet> findByName(String name);
}
