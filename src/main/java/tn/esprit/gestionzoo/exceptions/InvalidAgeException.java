package tn.esprit.gestionzoo.exceptions;

public class InvalidAgeException extends Exception {

    public InvalidAgeException() {
        super("The age of an animal cannot be negative.");
    }

    public InvalidAgeException(String message) {
        super(message);
    }
}
