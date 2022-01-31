package finki.ukim.mk.findmyplace.web.controller;

import finki.ukim.mk.findmyplace.model.dto.AmenityDto;
import finki.ukim.mk.findmyplace.model.dto.CityDto;
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

    private final RestTemplate restTemplate;

    // url to amenities microservice
    protected String url = "http://localhost:2222";

    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getHomePage(Model model, @RequestParam(required = false) String cityFilter, @RequestParam(required = false) String amenityType, @RequestParam(required = false) String search){
        // getting amenity dtos
        AmenityDto[] amenities;
        AmenityDto[] mostVisitedAmenities;
        CityDto[] cities;
        cities = restTemplate.getForObject(this.url + "/cities", CityDto[].class);
        model.addAttribute("cities", cities);

        if(cityFilter != null && !cityFilter.equals("") && amenityType != null && !amenityType.equals("")){
            if(cityFilter.equals("All") && amenityType.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities", AmenityDto[].class);
                mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisited", AmenityDto[].class);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited",mostVisitedAmenities);
            }
            else if(cityFilter.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities/type/{type}", AmenityDto[].class, amenityType);
                mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisitedByType/type/{type}", AmenityDto[].class, amenityType);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", mostVisitedAmenities);
            }
            else if(amenityType.equals("All")){
                amenities = restTemplate.getForObject(this.url + "/amenities/city/{city}", AmenityDto[].class, cityFilter);
                mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisitedByCity/city/{city}", AmenityDto[].class, cityFilter);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", mostVisitedAmenities);

            }
            else{
                amenities = restTemplate.getForObject(this.url + "/amenities/city/{city}/type/{type}", AmenityDto[].class, cityFilter, amenityType);
                mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisitedByCityAndType/city/{city}/type/{type}", AmenityDto[].class, cityFilter, amenityType);
                model.addAttribute("amenities", amenities);
                model.addAttribute("mostVisited", mostVisitedAmenities);
            }
        }
        else if(search != null && !search.equals("")){
            amenities = restTemplate.getForObject(this.url + "/amenity/name/{name}", AmenityDto[].class, search);
            mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisitedByText/text/{text}", AmenityDto[].class, search);
            model.addAttribute("amenities", amenities);
            model.addAttribute("mostVisited", mostVisitedAmenities);
        }
        else{
            amenities = restTemplate.getForObject(this.url + "/amenities", AmenityDto[].class);
            mostVisitedAmenities = restTemplate.getForObject(this.url + "/amenities/mostVisited", AmenityDto[].class);
            model.addAttribute("amenities", amenities);
            model.addAttribute("mostVisited", mostVisitedAmenities);
        }
        return "home";
    }

    @GetMapping("/details/{id}")
    public String getAmenityDetails(@PathVariable Long id, Model model){
        AmenityDto amenityDto = restTemplate.getForObject(this.url + "/amenity/{id}", AmenityDto.class, id);
        model.addAttribute("amenity", amenityDto);
        return "amenity-details";
    }

}
