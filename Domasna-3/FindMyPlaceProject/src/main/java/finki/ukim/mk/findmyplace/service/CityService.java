package finki.ukim.mk.findmyplace.service;

import finki.ukim.mk.findmyplace.model.City;
import org.springframework.stereotype.Service;

import java.util.*;

public interface CityService {
    City searchById(Long cityID);
    City searchByName(String name);
    List<City> showAll();
}
