package finki.ukim.mk.findmyplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FindMyPlaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindMyPlaceApplication.class, args);
    }

}
