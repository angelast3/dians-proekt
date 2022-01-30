package finki.ukim.mk.microservices.amenity.services;

import finki.ukim.mk.microservices.amenity.model.Amenity;
import java.util.List;

public interface AmenityService {
    Amenity findById(Long id);
    List<Amenity> showAll();
    List<Amenity> searchByName(String name);
    List<Amenity> searchByType(String type);
    List<Amenity> searchByCity(String city);
    List<Amenity> searchByCityAndType(String city, String type);
    List<Amenity> searchMostVisited(List<Amenity> ammenities);

}
