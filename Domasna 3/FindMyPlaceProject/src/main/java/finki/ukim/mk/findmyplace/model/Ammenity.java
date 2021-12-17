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
    private int visits;

    public Ammenity(String ammenityID,String name, String nameEn, Double longitude, Double latitude, String phoneNumber, String country, String city, String address, String openingHours, String website, int typeID) {
        this.ammenityID = Long.valueOf(ammenityID);
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
        visits = 0;
    }

    public void incrementVisits(){
        visits++;
    }
    public int compareTo(Ammenity element) {
        int res = 0;
        if (this.visits < element.getVisits()) {
            res = 1;
        }
        if (this.visits > element.getVisits()) {
            res =- 1;
        }
        return res;
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
