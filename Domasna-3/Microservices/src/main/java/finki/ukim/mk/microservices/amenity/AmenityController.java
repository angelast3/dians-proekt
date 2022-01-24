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

    @RequestMapping("/amenities/{id}")
    public Amenity getAmenity(@PathVariable Long id){
        return amenityRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
