package alekseytyan.config;

import alekseytyan.entity.Singer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"alekseytyan.*"})
public class AppConfig {

    @Bean
    public Singer eric() throws MalformedURLException {
        return new Singer(
                "Eric",
                "Clapton",
                DateTime.parse("1945-03-30"),
                new URL("http://www.ericclapton.com")
        );
    }

    @Value("#{countrySinger.firstName}")
    String firstName;

    @Value("#{countrySinger.lastName}")
    String lastName;

    @Value("#{countrySinger.birthdate}")
    DateTime birthdate;

    @Value("#{countrySinger.personalSite}")
    URL website;

    @Bean
    public Singer countrySinger() {
        return new Singer(firstName, lastName, birthdate, website);
    }
}
