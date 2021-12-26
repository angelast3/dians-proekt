package finki.ukim.mk.findmyplace.web.controller;

import finki.ukim.mk.findmyplace.model.Ammenity;
import finki.ukim.mk.findmyplace.model.City;
import finki.ukim.mk.findmyplace.service.AmmenityService;
import finki.ukim.mk.findmyplace.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final AmmenityService ammenityService;
    private final CityService cityService;

    public HomeController(AmmenityService ammenityService, CityService cityService) {
        this.ammenityService = ammenityService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getHomePage(Model model, @RequestParam(required = false) String cityFilter, @RequestParam(required = false) String amenityType, @RequestParam(required = false) String search){
        model.addAttribute("cities", cityService.showAll());
        if(cityFilter != null && !cityFilter.equals("") && amenityType != null && !amenityType.equals("")){
            if(cityFilter.equals("All") && amenityType.equals("All")){
                model.addAttribute("amenities", ammenityService.showAll());
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.showAll()));

            }
            else if(cityFilter.equals("All")){
                model.addAttribute("amenities", ammenityService.searchByType(amenityType));
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByType(amenityType)));
            }
            else if(amenityType.equals("All")){
                model.addAttribute("amenities", ammenityService.searchByCity(cityFilter));
                model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByCity(cityFilter)));

            }
            else{
                model.addAttribute("amenities", ammenityService.searchByCityAndType(cityFilter, amenityType));
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
            model.addAttribute("amenities", ammenityService.searchByText(search));
            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.searchByText(search)));
        }
        else{
            model.addAttribute("amenities", ammenityService.showAll());
            model.addAttribute("mostVisited", ammenityService.searchMostVisited(ammenityService.showAll()));
        }
        return "home";
    }

    @GetMapping("/details/{id}")
    public String getAmenityDetails(@PathVariable Long id, Model model){
        Ammenity amenity = ammenityService.findById(id);
        amenity.incrementVisits();
        model.addAttribute("amenity", amenity);
        return "amenity-details";
    }


}
