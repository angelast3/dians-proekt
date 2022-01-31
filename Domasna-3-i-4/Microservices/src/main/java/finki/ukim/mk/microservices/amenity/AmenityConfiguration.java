package finki.ukim.mk.microservices.amenity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@EntityScan("finki.ukim.mk.microservices.amenity.model")
public class AmenityConfiguration {

    protected Logger logger;

    public AmenityConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

}
