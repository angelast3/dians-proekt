package finki.ukim.mk.microservices.amenity.model;

import lombok.Data;
@Data
public class City {
    private Long cityID;
    private String name;

    public City(String name) {
        this.cityID = (long)(Math.random() * 1000);
        this.name = name;
    }
}
