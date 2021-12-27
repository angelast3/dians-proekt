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

@Controller
@RequestMapping("/")
public class HomeController {

    private final AmmenityService ammenityService;
    private final CityService cityService;

    public HomeController(AmmenityService ammenityService, CityService cityService) {
        this.ammenityService = ammenityService;
        this.cityService = cityService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("amenities", ammenityService.showAll());
        model.addAttribute("cities", cityService.showAll());
        return "home";
    }

    @GetMapping("/details/{id}")
    public String getAmenityDetails(@PathVariable Long id, Model model){
        Ammenity amenity = ammenityService.findById(id);
        model.addAttribute("amenity", amenity);
        return "amenity-details";
    }

    @GetMapping("/contact-us")
    public String contactUs(){
        return "contactUs";
    }
}
