package tn.esprit.gestionzoo.exceptions;

// Instruction 33 : custom exception raised when the zoo has no free cage left
public class ZooFullException extends Exception {

    public ZooFullException() {
        super("The zoo is full: no more cages available.");
    }

    public ZooFullException(String message) {
        super(message);
    }
}
