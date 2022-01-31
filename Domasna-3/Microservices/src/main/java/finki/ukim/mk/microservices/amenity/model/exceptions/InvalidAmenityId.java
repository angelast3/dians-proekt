package finki.ukim.mk.microservices.amenity.model.exceptions;

public class InvalidAmenityId extends RuntimeException{
    public InvalidAmenityId() {
        super("The searched id for amenity is invalid");
    }
}
