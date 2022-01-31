package finki.ukim.mk.findmyplace.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityDto implements Serializable {
    private Long cityID;
    private String name;
}
