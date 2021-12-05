package finki.ukim.mk.findmyplace.repository;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.model.AmmenityDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AmmenityRepository {
    public static List<Ammenity> ammenityList = new ArrayList<>();
    private final CityRepository cityRepository = new CityRepository();

    public AmmenityRepository() throws IOException {
        BufferedReader barCsvReader = new BufferedReader(new FileReader("src/main/java/finki/ukim/mk/findmyplace/repository/barDataset.csv"));
        BufferedReader cafeCsvReader = new BufferedReader(new FileReader("src/main/java/finki/ukim/mk/findmyplace/repository/cafeDataset.csv"));
        String row = "";
        int flag = 0;
        Random random = new Random();

        while((row = barCsvReader.readLine())!= null){
            String []barData = row.split(",");
            if ( flag > 0 ){
                ammenityList.add(new Ammenity(barData[3], barData[3], Double.parseDouble(barData[1]), Double.parseDouble(barData[2]), "07" + String.format("%07d", random.nextInt(10000000)), "MK", cityRepository.findByName("Skopje").getCityID(), "Partizanska", "09:00-01:00", "", 1));
            }
            flag++;
        }

        flag = 0;
        while((row = cafeCsvReader.readLine())!= null){
            String []cafeData = row.split(",");
            if (flag > 0){
                ammenityList.add(new Ammenity(cafeData[3], cafeData[3], Double.parseDouble(cafeData[1]), Double.parseDouble(cafeData[2]),"07" + String.format("%07d", random.nextInt(10000000)), "MK", cityRepository.findByName("Skopje").getCityID(), "Partizanska", "09:00-01:00", "", 0));
            }
            flag++;
        }

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
