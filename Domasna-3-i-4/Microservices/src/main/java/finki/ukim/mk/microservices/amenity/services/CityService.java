package finki.ukim.mk.microservices.amenity.services;

import finki.ukim.mk.microservices.amenity.model.City;

import java.util.List;

public interface CityService {
    City searchById(Long cityID);
    City searchByName(String name);
    List<City> showAll();
}
