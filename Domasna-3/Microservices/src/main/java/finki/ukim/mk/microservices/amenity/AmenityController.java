package finki.ukim.mk.microservices.amenity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmenityController {

    protected AmenityRepository amenityRepository;

    @Autowired
    public AmenityController(AmenityRepository amenityRepository){
        this.amenityRepository = amenityRepository;
    }

    @RequestMapping("/amenities")
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    @RequestMapping("/amenity/{id}")
    public Amenity getAmenity(@PathVariable Long id){
        return amenityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @RequestMapping("/amenities/type/{type}")
    public List<Amenity> getAmenitiesByType(@PathVariable String type){
        return amenityRepository.findAmenitiesByType(AmenityType.valueOf(type));
    }

    @RequestMapping("/amenities/city/{city}")
    public List<Amenity> getAmenitiesByCity(@PathVariable String city){
        return amenityRepository.findAmenitiesByCity(city);
    }

    @RequestMapping("/amenities/city/{city}/type/{type}")
    public List<Amenity> getAmenitiesByCityAndType(@PathVariable String city, @PathVariable String type){
        return amenityRepository.findAmenitiesByCityAndType(city, AmenityType.valueOf(type));
    }

    @RequestMapping("/amenity/name/{name}")
    public Amenity getAmenityByName(@PathVariable String name){
        return amenityRepository.findAmenityByName(name);
    }

}
