package me.cnpe.petclinic.exception;

public class DuplicatedResourceException extends RuntimeException {

  public DuplicatedResourceException(String identifier) {
    super("Resource with identifier [" + identifier + "] already exists.");
  }

  public DuplicatedResourceException() {
    super("A resource with that name already exists.");
  }
}
