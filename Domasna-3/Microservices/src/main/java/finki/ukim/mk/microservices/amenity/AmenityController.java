package finki.ukim.mk.microservices.amenity;

import finki.ukim.mk.microservices.amenity.model.Amenity;
import finki.ukim.mk.microservices.amenity.services.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmenityController {

    private final AmenityService amenityService;

    @Autowired
    public AmenityController(AmenityService amenityService){
        this.amenityService = amenityService;
    }

    @RequestMapping("/amenities")
    public List<Amenity> getAllAmenities() {
        return this.amenityService.showAll();
    }

    @RequestMapping("/amenity/{id}")
    public Amenity getAmenity(@PathVariable Long id){
        return amenityService.findById(id);
    }

    @RequestMapping("/amenities/type/{type}")
    public List<Amenity> getAmenitiesByType(@PathVariable String type){
        return amenityService.searchByType(type);
    }

    @RequestMapping("/amenities/city/{city}")
    public List<Amenity> getAmenitiesByCity(@PathVariable String city){
        return amenityService.searchByCity(city);
    }

    @RequestMapping("/amenities/city/{city}/type/{type}")
    public List<Amenity> getAmenitiesByCityAndType(@PathVariable String city, @PathVariable String type){
        return this.amenityService.searchByCityAndType(city, type);
    }

    @RequestMapping("/amenity/name/{name}")
    public List<Amenity> getAmenityByName(@PathVariable String name){
        return this.amenityService.searchByName(name);
    }

}
