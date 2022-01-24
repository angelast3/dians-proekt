package finki.ukim.mk.microservices.amenity;
import org.springframework.data.jpa.repository.JpaRepository;;

// TODO: make sure that this works with JpaRepository, if not use: import org.springframework.data.repository.Repository;
public interface AmenityRepository extends JpaRepository<Amenity, Long>{
}
