package finki.ukim.mk.microservices.amenity.model.exceptions;

public class InvalidCityId extends RuntimeException{
    public InvalidCityId() {
        super("The searched id for city is invalid");
    }
}
