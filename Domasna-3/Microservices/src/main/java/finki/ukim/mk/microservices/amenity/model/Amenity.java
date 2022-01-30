package finki.ukim.mk.microservices.amenity.model;

import javax.persistence.*;

@Entity
@Table(name = "amenities")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityID;
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
    private AmenityType type;
    private int visits;

    public Amenity(String amenityID,String name, String nameEn, Double longitude, Double latitude, String phoneNumber, String country, String city, String address, String openingHours, String website, int typeID) {
        this.amenityID = Long.valueOf(amenityID);
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
        for (AmenityType t : AmenityType.values()) {
            if(t.getId() == typeID){
                this.type = t;
            }
        }
    }

    public Amenity() {

    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(AmenityType type) {
        this.type = type;
    }

    public Long getAmenityID() {
        return amenityID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public AmenityType getType() {
        return type;
    }

    public int getVisits() {
        return visits;
    }


    public void incrementVisits(){
        visits++;
    }

    public int compareTo(Amenity element) {
        int res = 0;
        if (this.visits < element.getVisits()) {
            res = 1;
        }
        if (this.visits > element.getVisits()) {
            res =- 1;
        }
        return res;
    }

}

