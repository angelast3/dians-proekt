package finki.ukim.mk.findmyplace.service.implementations;

import finki.ukim.mk.findmyplace.model.City;
import finki.ukim.mk.findmyplace.repository.CityRepository;
import finki.ukim.mk.findmyplace.service.CityService;
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
