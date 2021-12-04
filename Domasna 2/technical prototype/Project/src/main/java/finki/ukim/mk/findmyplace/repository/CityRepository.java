package finki.ukim.mk.findmyplace.repository;

import finki.ukim.mk.findmyplace.model.City;
import finki.ukim.mk.findmyplace.model.CityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CityRepository {
    public static List<City> cityList = new ArrayList<>();

    public CityRepository() {
        cityList.add(new City("Skopje"));
        cityList.add(new City("Kumanovo"));
        cityList.add(new City("Bitola"));
        cityList.add(new City("Ohrid"));
    }

    public List<City> listAll(){
        return cityList;
    }

    public City findByName(String name){
        return cityList.stream()
                .filter(x->x.getName().equals(name))
                .findFirst().orElseThrow(CityNotFoundException :: new);
    }

    public City findById(Long cityId){
        return cityList.stream()
                .filter(x->x.getCityID().equals(cityId))
                .findFirst().orElseThrow(CityNotFoundException :: new);
    }
}
