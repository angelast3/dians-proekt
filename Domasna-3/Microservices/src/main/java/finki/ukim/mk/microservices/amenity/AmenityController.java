package finki.ukim.mk.microservices.amenity;

import finki.ukim.mk.microservices.amenity.model.Amenity;
import finki.ukim.mk.microservices.amenity.model.City;
import finki.ukim.mk.microservices.amenity.services.AmenityService;
import finki.ukim.mk.microservices.amenity.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmenityController {

    private final AmenityService amenityService;
    private final CityService cityService;

    @Autowired
    public AmenityController(AmenityService amenityService, CityService cityService){
        this.amenityService = amenityService;
        this.cityService = cityService;
    }

    @RequestMapping("/amenities")
    public List<Amenity> getAllAmenities() {
        return this.amenityService.showAll();
    }

    @RequestMapping("/cities")
    public List<City> getAllCities() {
        return this.cityService.showAll();
    }

    @RequestMapping("/amenity/{id}")
    public Amenity getAmenity(@PathVariable Long id){
        this.amenityService.incrementVisited(id);
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

    @RequestMapping("/amenities/mostVisited")
    public List<Amenity> getMostVisited(){
        return this.amenityService.searchMostVisited(this.amenityService.showAll());
    }

    @RequestMapping("/amenities/mostVisitedByType/type/{type}")
    public List<Amenity> getMostVisitedByType(@PathVariable String type){
        return this.amenityService.searchMostVisited(this.amenityService.searchByType(type));
    }

    @RequestMapping("/amenities/mostVisitedByCity/city/{city}")
    public List<Amenity> getMostVisitedByCity(@PathVariable String city){
        return this.amenityService.searchMostVisited(this.amenityService.searchByCity(city));
    }

    @RequestMapping("/amenities/mostVisitedByCityAndType/city/{city}/type/{type}")
    public List<Amenity> getMostVisitedByCityAndType(@PathVariable String city, @PathVariable String type){
        return this.amenityService.searchMostVisited(this.amenityService.searchByCityAndType(city, type));
    }

    @RequestMapping("/amenities/mostVisitedByText/text/{text}")
    public List<Amenity> getMostVisitedByText(@PathVariable String text){
        return this.amenityService.searchMostVisited(this.amenityService.searchByName(text));
    }
}
