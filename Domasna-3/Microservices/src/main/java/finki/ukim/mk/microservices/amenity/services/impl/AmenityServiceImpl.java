package finki.ukim.mk.microservices.amenity.services.impl;

import finki.ukim.mk.microservices.amenity.model.Amenity;
import finki.ukim.mk.microservices.amenity.model.exceptions.InvalidAmenityId;
import finki.ukim.mk.microservices.amenity.services.AmenityService;
import finki.ukim.mk.microservices.amenity.repositories.AmenityCsvRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceImpl implements AmenityService {


    private final AmenityCsvRepository amenityCsvRepository;

    public AmenityServiceImpl(AmenityCsvRepository amenityCsvRepository) {
        this.amenityCsvRepository = amenityCsvRepository;
    }

    @Override
    public Amenity findById(Long id) {
        return this.amenityCsvRepository.findById(id).orElseThrow(InvalidAmenityId::new);
    }

    @Override
    public List<Amenity> showAll() {
        return this.amenityCsvRepository.listAll();

    }

    @Override
    public List<Amenity> searchByName(String name) {
        return this.amenityCsvRepository.findByText(name);
    }

    @Override
    public List<Amenity> searchByType(String type) {
        return this.amenityCsvRepository.listByAmmenityType(type);
    }

    @Override
    public List<Amenity> searchByCity(String city) {
        return this.amenityCsvRepository.listByCity(city);
    }

    @Override
    public List<Amenity> searchByCityAndType(String city, String type) {
        return this.amenityCsvRepository.listByCityAndType(city, type);
    }

    @Override
    public List<Amenity> searchMostVisited(List<Amenity> amenities) {
        Amenity temp;
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < amenities.size() - 1; i++) {
                if (amenities.get(i).compareTo(amenities.get(i + 1)) > 0) {
                    temp = amenities.get(i);
                    amenities.set(i, amenities.get(i + 1));
                    amenities.set(i + 1, temp);
                }
            }
        }
        if (amenities.size() < 5)
            return amenities;
        else
            return amenities.subList(0, 5);
    }

}
