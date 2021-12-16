package finki.ukim.mk.findmyplace.model;

public class AmmenityDoesNotExistException extends RuntimeException{
    public AmmenityDoesNotExistException() {
        super("The searched ammenity does not exist");
    }
}
