package me.cnpe.petclinic.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(Long ownerId) {
    super("Resource with ID [" + ownerId + "] was not found.");
  }
}
