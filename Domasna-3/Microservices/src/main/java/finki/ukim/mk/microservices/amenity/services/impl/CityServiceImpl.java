package finki.ukim.mk.microservices.amenity.services.impl;

import finki.ukim.mk.microservices.amenity.model.City;
import finki.ukim.mk.microservices.amenity.repositories.CityRepository;
import finki.ukim.mk.microservices.amenity.services.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City searchById(Long cityID) {
        return this.cityRepository.findById(cityID);
    }

    @Override
    public City searchByName(String name) {
        return this.cityRepository.findByName(name);
    }

    @Override
    public List<City> showAll() {
        return this.cityRepository.listAll();
    }
}