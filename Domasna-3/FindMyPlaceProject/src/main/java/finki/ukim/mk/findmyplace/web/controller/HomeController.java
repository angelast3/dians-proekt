package finki.ukim.mk.findmyplace.web.controller;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.model.dto.AmenityDto;
import finki.ukim.mk.findmyplace.service.AmmenityService;
import finki.ukim.mk.findmyplace.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final AmmenityService ammenityService;
    private final CityService cityService;
    private final RestTemplate restTemplate;

    // url to amenities microservice
    protected String url = "http://localhost:2222";

    public HomeController(AmmenityService ammenityService, CityService cityService, RestTemplate restTemplate) {
        this.ammenityService = ammenityService;
        this.cityService = cityService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getHomePage(Model model, @RequestParam(required = false) String cityFilter, @RequestParam(required = false) String amenityType, @RequestParam(required = false) String search){
        model.addAttribute("cities", cityService.showAll());

        // getting amenity dtos
        AmenityDto[] amenities = null;

        if(cityFilter != null && !cityFilter.equals("") && amenityType != null && !amenityType.equals("")){
            if(cityFilter.equals("All") && amenityType.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities", AmenityDto[].class);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.showAll()));
            }
            else if(cityFilter.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities/type/{type}", AmenityDto[].class, amenityType);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByType(amenityType)));
            }
            else if(amenityType.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities/city/{city}", AmenityDto[].class, cityFilter);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByCity(cityFilter)));

            }
            else{
                amenities = restTemplate.getForObject(this.url + "/amenities/city/{city}/type/{type}", AmenityDto[].class, cityFilter, amenityType);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByCityAndType(cityFilter, amenityType)));
            }
        }
//        else if(cityFilter != null && !cityFilter.equals(""))
//        {
//            model.addAttribute("amenities", ammenityService.searchByCity(cityFilter));
//            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByCity(cityFilter)));
//        }
//        else if (amenityType != null && !amenityType.equals("")){
//            model.addAttribute("amenities", ammenityService.searchByType(amenityType));
//            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByType(amenityType)));
//        }
        else if(search != null && !search.equals("")){
            AmenityDto amenity = restTemplate.getForObject(this.url + "/amenity/name/{name}", AmenityDto.class, search);
            model.addAttribute("amenities", amenity);
            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByText(search)));
        }
        else{
            amenities = restTemplate.getForObject(this.url + "/amenities", AmenityDto[].class);
            model.addAttribute("amenities", amenities);
            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.showAll()));
        }
        return "home";
    }

    @GetMapping("/details/{id}")
    public String getAmenityDetails(@PathVariable Long id, Model model){
        AmenityDto amenityDto = restTemplate.getForObject(this.url + "/amenity/{id}", AmenityDto.class, id);
        // amenity.incrementVisits();
        model.addAttribute("amenity", amenityDto);
        return "amenity-details";
    }

}
