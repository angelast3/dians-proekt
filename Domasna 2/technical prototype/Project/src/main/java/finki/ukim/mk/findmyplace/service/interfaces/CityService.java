package finki.ukim.mk.findmyplace.service.interfaces;

import finki.ukim.mk.findmyplace.model.City;

import java.util.*;

public interface CityService {
    City searchById(Long cityID);
    City searchByName(String name);
    List<City> showAll();
}
