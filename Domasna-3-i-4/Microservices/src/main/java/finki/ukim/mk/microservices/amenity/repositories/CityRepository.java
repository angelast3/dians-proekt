package finki.ukim.mk.microservices.amenity.repositories;


import finki.ukim.mk.microservices.amenity.model.City;
import finki.ukim.mk.microservices.amenity.model.exceptions.InvalidCityId;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class CityRepository {
    public static List<City> cityList = new ArrayList<>();


    public CityRepository(AmenityCsvRepository amenityRepository) {
        amenityRepository.listAll()
                .forEach(x->{
                    if(x.getCity() != null){
                        AtomicBoolean flag = new AtomicBoolean(true);
                        if(!cityList.isEmpty()){
                            cityList.forEach(el -> {
                                if (el.getName().equals(x.getCity())) {
                                    flag.set(false);
                                }
                            });
                        }
                        if(flag.get()){
                            cityList.add(new City(x.getCity()));
                        }
                    }
                });
    }

    public List<City> listAll(){
        return cityList;
    }

    public City findByName(String name){
        return cityList.stream()
                .filter(x->x.getName().equals(name))
                .findFirst().orElseThrow(InvalidCityId:: new);
    }

    public City findById(Long cityId){
        return cityList.stream()
                .filter(x->x.getCityID().equals(cityId))
                .findFirst().orElseThrow(InvalidCityId :: new);
    }
}
