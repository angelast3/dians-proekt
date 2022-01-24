package finki.ukim.mk.microservices.services.web;

import finki.ukim.mk.microservices.amenity.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class WebAmenityService {
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public WebAmenityService(String serviceUrl){
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public List<Amenity> getAllAmenities() {
        Amenity[] amenities = null;

        try{
            amenities = restTemplate.getForObject(serviceUrl + "/amenities", Amenity[].class);
        }catch (HttpClientErrorException e){
            // 404
        }

        if (amenities == null || amenities.length == 0){
            return null;
        }

        return Arrays.asList(amenities);
    }

    public Amenity getById(String id){
        return restTemplate.getForObject(serviceUrl + "/amenities/{id}", Amenity.class, id);
    }
}
