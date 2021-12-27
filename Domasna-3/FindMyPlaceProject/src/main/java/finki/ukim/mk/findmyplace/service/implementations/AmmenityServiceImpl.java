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
    public Ammenity findById(Long id) {
        return this.ammenityRepository.findById(id).orElseThrow();
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
    public List<Ammenity> searchByCity(String city) {
        return this.ammenityRepository.listByCity(city);
    }

    @Override
    public List<Ammenity> searchByCityAndType(String city, String type) {
        return this.ammenityRepository.listByCityAndType(city, type);
    }

    @Override
    public List<Ammenity> searchByText(String text) {
        return this.ammenityRepository.findByText(text);
    }

    @Override
    public List<Ammenity> searchMostVisited(List<Ammenity> ammenities) {
        Ammenity temp;
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < ammenities.size() - 1; i++) {
                if (ammenities.get(i).compareTo(ammenities.get(i + 1)) > 0) {
                    temp = ammenities.get(i);
                    ammenities.set(i, ammenities.get(i + 1));
                    ammenities.set(i + 1, temp);
                }
            }
        }
        if (ammenities.size() < 5)
            return ammenities;
        else
            return ammenities.subList(0, 5);
    }
}
