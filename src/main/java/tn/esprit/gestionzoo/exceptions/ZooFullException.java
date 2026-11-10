package tn.esprit.gestionzoo.exceptions;

public class ZooFullException extends Exception {

    public ZooFullException() {
        super("The zoo is full: no more cages available.");
    }

    public ZooFullException(String message) {
        super(message);
    }
}
