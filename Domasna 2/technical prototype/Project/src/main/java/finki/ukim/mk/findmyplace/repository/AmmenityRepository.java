package finki.ukim.mk.findmyplace.repository;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.model.AmmenityDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AmmenityRepository {
    public static List<Ammenity> ammenityList = new ArrayList<>();
    private final CityRepository cityRepository = new CityRepository();

    public AmmenityRepository() {
        ammenityList.add(new Ammenity("Broz Cafe", "Broz Cafe", 21.416703, 42.0001541, "070000000", "MK", cityRepository.findByName("Skopje").getCityID(), "Partizanska", "24/7", "www.example.com", 0));
        ammenityList.add(new Ammenity("Play Cafe", "Play Cafe", 21.429836, 41.992653, "070111111", "MK", cityRepository.findByName("Skopje").getCityID(), "Jane Sandanski", "Mo-Su 09:00-21:00", "www.example.com", 0));
    }

    public List<Ammenity> listAll(){
        return ammenityList;
    }

    public Ammenity findByName(String name){
        return ammenityList.stream().filter(x->x.getName().equals(name) || x.getNameEn().equals(name))
                .findFirst().orElseThrow(AmmenityDoesNotExistException::new);
    }

    public List<Ammenity> listByAmmenityType(String type){
        return ammenityList.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Ammenity> listByCity(Long cityID){
        return ammenityList.stream()
                .filter(x->x.getCityID().equals(cityID))
                .collect(Collectors.toList());
    }
}
