package finki.ukim.mk.microservices.amenity.repositories;

import finki.ukim.mk.microservices.amenity.model.Amenity;
import finki.ukim.mk.microservices.amenity.model.AmenityType;
import org.springframework.stereotype.Repository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class AmenityCsvRepository {
    public static List<Amenity> amenityList = new LinkedList<>();

    public AmenityCsvRepository() throws IOException {
        BufferedReader barCsvReader = new BufferedReader(new FileReader("src/main/resources/db/barDataset.csv"));
        BufferedReader cafeCsvReader = new BufferedReader(new FileReader("src/main/resources/db/cafeDataset.csv"));
        String row;
        int flag = 0;
        Random random = new Random();

        while((row = barCsvReader.readLine())!= null){
            String []barData = row.split(",");
            if ( flag > 0 ){
                amenityList.add(new Amenity(barData[0], barData[4], barData[3], Double.parseDouble(barData[1]), Double.parseDouble(barData[2]), "07" + String.format("%07d", random.nextInt(10000000)), "MK", barData.length >= 7 && !barData[6].equals("") ? barData[6] : null, barData.length >= 8 && !barData[7].equals("") ? barData[7] : null, barData.length >= 9 && !barData[8].equals("") ? barData[8] : null, "", 1));
            }
            flag++;
        }

        flag = 0;
        while((row = cafeCsvReader.readLine())!= null){
            String []cafeData = row.split(",");
            if (flag > 0){
                amenityList.add(new Amenity(cafeData[0], cafeData[4], cafeData[3], Double.parseDouble(cafeData[1]), Double.parseDouble(cafeData[2]),"07" + String.format("%07d", random.nextInt(10000000)), "MK", cafeData.length >= 7 && !cafeData[6].equals("") ? cafeData[6] : null, cafeData.length >= 8 && !cafeData[7].equals("") ? cafeData[7] : null, cafeData.length >= 9 && !cafeData[8].equals("") ? cafeData[8] : null, "", 0));
            }
            flag++;
        }

    }

    public Optional<Amenity> findById(Long id){
        return amenityList.stream().filter(x -> x.getAmenityID().equals(id)).findFirst();
    }

    public List<Amenity> listAll(){
        return amenityList;
    }

    public List<Amenity> listByAmmenityType(String type){
        return amenityList.stream()
                .filter(x->x.getType() == AmenityType.valueOf(type))
                .collect(Collectors.toList());
    }

    public List<Amenity> listByCity(String city){
        return amenityList.stream()
                .filter(x->x.getCity()!=null && x.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Amenity> listByCityAndType(String city, String type) {
        return amenityList.stream()
                .filter(x-> x.getCity()!=null && x.getCity().equals(city) && x.getType() == AmenityType.valueOf(type))
                .collect(Collectors.toList());
    }

    public List<Amenity> findByText(String text) {
        return amenityList.stream()
                .filter(x->x.getName().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }
}
