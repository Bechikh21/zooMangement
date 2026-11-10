package tn.esprit.gestionzoo.exceptions;

// Instruction 34 : custom exception raised when an animal has a negative age
public class InvalidAgeException extends Exception {

    public InvalidAgeException() {
        super("The age of an animal cannot be negative.");
    }

    public InvalidAgeException(String message) {
        super(message);
    }
}
