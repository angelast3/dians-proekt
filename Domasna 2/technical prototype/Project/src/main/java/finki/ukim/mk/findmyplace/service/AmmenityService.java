package finki.ukim.mk.findmyplace.service;

import finki.ukim.mk.findmyplace.model.Ammenity;

import java.util.*;

public interface AmmenityService {
    List<Ammenity> showAll();
    Ammenity searchByName(String name);
    List<Ammenity> searchByType(String type);
    List<Ammenity> searchByCity(Long cityID);
}
