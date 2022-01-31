package finki.ukim.mk.microservices.services.amenity;

import finki.ukim.mk.microservices.amenity.AmenityConfiguration;
import finki.ukim.mk.microservices.services.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.util.logging.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@Import(AmenityConfiguration.class)
public class AmenityServer {

    protected Logger logger = Logger.getLogger(AmenityServer.class.getName());

    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        // Tell server to look for amenity-server.properties
        System.setProperty("spring.config.name", "amenity-server");

        SpringApplication.run(AmenityServer.class, args);
    }
}
