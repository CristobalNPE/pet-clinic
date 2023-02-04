package me.cnpe.petclinic.controller;

import lombok.RequiredArgsConstructor;
import me.cnpe.petclinic.dto.PetDto;
import me.cnpe.petclinic.dto.PetSlimDto;
import me.cnpe.petclinic.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
public class PetController {

  private final PetService petService;

  @GetMapping
  public List<PetSlimDto> getAllPets() {
    return petService.findAllPets();
  }

  @PostMapping
  public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto) {

    var savedPet = petService.savePet(petDto);

    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/")
            .buildAndExpand(savedPet.getName())
            .toUri();

    return ResponseEntity.created(location).body(savedPet);


  }

}
