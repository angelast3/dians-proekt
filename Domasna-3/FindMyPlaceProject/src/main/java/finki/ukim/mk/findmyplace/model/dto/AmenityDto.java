package finki.ukim.mk.findmyplace.model.dto;

import finki.ukim.mk.findmyplace.model.AmmenityType;
import lombok.Data;

import java.io.Serializable;

@Data
public class AmenityDto implements Serializable {
    private Long amenityID;
    private String address;
    private String openingHours;
    private String phoneNumber;
    private Double longitude;
    private Double latitude;
    private String name;
    private String city;
    private AmmenityType type;
    private int visits;

    public String getType() {
        return type.name();
    }
}
