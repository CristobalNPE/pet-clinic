package me.cnpe.petclinic.repository;

import me.cnpe.petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

  Optional<Owner> findByRut(String rut);

}
