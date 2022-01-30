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
@EnableJpaRepositories("finki.ukim.mk.microservices.amenity.repositories")
@PropertySource("classpath:db-config.properties")
public class AmenityConfiguration {

    protected Logger logger;

    public AmenityConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");

        // Create an in-memory H2 relational database containing some amenities
        DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:db/schema.sql")
                .addScript("classpath:db/data.sql").build();


        logger.info("dataSource = " + dataSource);

        return dataSource;
    }
}
