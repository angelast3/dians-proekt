package finki.ukim.mk.findmyplace.repository;

import finki.ukim.mk.findmyplace.model.City;
import finki.ukim.mk.findmyplace.model.CityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class CityRepository {
    public static List<City> cityList = new ArrayList<>();
    private final AmmenityRepository ammenityRepository;

    public CityRepository(AmmenityRepository ammenityRepository) {
        this.ammenityRepository = ammenityRepository;
        ammenityRepository.listAll().stream()
                .forEach(x->{
                    if(x.getCity() != null){
                        AtomicBoolean flag = new AtomicBoolean(true);
                        if(!cityList.isEmpty()){
                            cityList.stream().forEach(el -> {
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
                .findFirst().orElseThrow(CityNotFoundException :: new);
    }

    public City findById(Long cityId){
        return cityList.stream()
                .filter(x->x.getCityID().equals(cityId))
                .findFirst().orElseThrow(CityNotFoundException :: new);
    }
}
