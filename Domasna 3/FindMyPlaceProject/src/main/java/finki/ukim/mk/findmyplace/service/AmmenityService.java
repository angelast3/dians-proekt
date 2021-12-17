package finki.ukim.mk.findmyplace.service;

import finki.ukim.mk.findmyplace.model.Ammenity;
import org.springframework.stereotype.Service;

import java.util.*;

public interface AmmenityService {
    Ammenity findById(Long id);
    List<Ammenity> showAll();
    Ammenity searchByName(String name);
    List<Ammenity> searchByType(String type);
    List<Ammenity> searchByCity(String city);
    List<Ammenity> searchByCityAndType(String city, String type);
    List<Ammenity> searchByText(String text);
    List<Ammenity> searchMostVisited(List<Ammenity> ammenities);
}
