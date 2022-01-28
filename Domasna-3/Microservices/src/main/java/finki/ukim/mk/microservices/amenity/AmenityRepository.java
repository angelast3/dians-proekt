package finki.ukim.mk.microservices.amenity;
import org.springframework.data.jpa.repository.JpaRepository;;import java.util.List;

public interface AmenityRepository extends JpaRepository<Amenity, Long>{
    public List<Amenity> findAmenitiesByType(AmenityType type);
    public List<Amenity> findAmenitiesByCity(String city);
    public List<Amenity> findAmenitiesByCityAndType(String city, AmenityType type);
    public Amenity findAmenityByName(String name);
}
