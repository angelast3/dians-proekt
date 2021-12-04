package finki.ukim.mk.findmyplace.service.implementations;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.repository.AmmenityRepository;
import finki.ukim.mk.findmyplace.service.AmmenityService;

import java.util.List;

public class AmmenityServiceImpl implements AmmenityService {

    private final AmmenityRepository ammenityRepository;

    public AmmenityServiceImpl(AmmenityRepository ammenityRepository) {
        this.ammenityRepository = ammenityRepository;
    }

    @Override
    public List<Ammenity> showAll() {
        return this.ammenityRepository.listAll();
    }

    @Override
    public Ammenity searchByName(String name) {
        return this.ammenityRepository.findByName(name);
    }

    @Override
    public List<Ammenity> searchByType(String type) {
        return this.ammenityRepository.listByAmmenityType(type);
    }

    @Override
    public List<Ammenity> searchByCity(Long cityID) {
        return this.ammenityRepository.listByCity(cityID);
    }
}
