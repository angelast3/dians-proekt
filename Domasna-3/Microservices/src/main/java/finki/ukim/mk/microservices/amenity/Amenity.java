package finki.ukim.mk.microservices.amenity;

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

    public void setAmenityID(Long amenityID) {
        this.amenityID = amenityID;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setType(AmenityType type) {
        this.type = type;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public Long getAmenityID() {
        return amenityID;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public String getWebsite() {
        return website;
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
enum AmenityType{
    Cafe(0),
    Bar(1);
    private final int id;
    int getId(){
        return id;
    }
    AmenityType(int id){
        this.id = id;
    }
}
