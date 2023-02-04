package me.cnpe.petclinic.exception;

public class DuplicatedNameException extends RuntimeException {

  public DuplicatedNameException(String name) {
    super("Resource with name [" + name + "] already exists.");
  }

  public DuplicatedNameException() {
    super("A resource with that name already exists.");
  }
}
