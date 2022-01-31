package finki.ukim.mk.microservices.amenity.model;

public enum AmenityType{
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
