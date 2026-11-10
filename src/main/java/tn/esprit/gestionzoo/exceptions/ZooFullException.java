package tn.esprit.gestionzoo.exceptions;

public class ZooFullException extends Exception {

    public ZooFullException() {
        super("The zoo is full.");
    }

    public ZooFullException(String message) {
        super(message);
    }
}
