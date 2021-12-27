package finki.ukim.mk.findmyplace.service.implementations;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.repository.AmmenityRepository;
import finki.ukim.mk.findmyplace.service.AmmenityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmmenityServiceImpl implements AmmenityService {

    private final AmmenityRepository ammenityRepository;

    public AmmenityServiceImpl(AmmenityRepository ammenityRepository) {
        this.ammenityRepository = ammenityRepository;
    }

    @Override
    public Ammenity findById(Long id){return this.ammenityRepository.findById(id).orElseThrow();}

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
    public List<Ammenity> searchByCity(String city) {
        return this.ammenityRepository.listByCity(city);
    }
}
