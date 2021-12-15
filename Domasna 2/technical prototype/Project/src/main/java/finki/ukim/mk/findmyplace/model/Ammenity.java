package finki.ukim.mk.findmyplace.model;

import lombok.Data;

@Data
public class Ammenity {
    private Long ammenityID;
    private Double longitude;
    private Double latitude;
    private String name;
    private String nameEn;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String openingHours;
    private String website;
    private AmmenityType type;

    public Ammenity(String name, String nameEn, Double longitude, Double latitude, String phoneNumber, String country, String city, String address, String openingHours, String website, int typeID) {
        this.ammenityID = (long)(Math.random() * 1000);
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.nameEn = nameEn;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.address = address;
        this.openingHours = openingHours;
        this.website = website;
        for (AmmenityType t : AmmenityType.values()) {
            if(t.getId() == typeID){
                this.type = t;
            }
        }
    }

    public String getType() {
        return type.name();
    }

    public String getName() {
        return name;
    }
}
enum AmmenityType{
    Cafe(0),
    Bar(1);
    private final int id;
    int getId(){
        return id;
    }
    AmmenityType(int id){
        this.id = id;
    }
}
