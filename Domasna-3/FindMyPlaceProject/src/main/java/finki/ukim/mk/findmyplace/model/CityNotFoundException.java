package finki.ukim.mk.findmyplace.model;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException() {
        super("There are not informations about the city you just searched");
    }
}
