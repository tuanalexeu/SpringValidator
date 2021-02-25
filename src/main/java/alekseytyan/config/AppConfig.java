package alekseytyan.config;

import alekseytyan.converter.StringToDateTimeConverter;
import alekseytyan.entity.Singer;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"alekseytyan.*"})
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${date.format.pattern}")
    private String dateFormatPattern;

    @Bean
    public Singer eric() throws MalformedURLException {
        return new Singer(
                "Eric",
                "Clapton",
                DateTime.parse("1945-03-30"),
                new URL("http://www.ericclapton.com")
        );
    }

    @Bean
    public Singer countrySinger(@Value("${countrySinger.firstName}") String firstName,
                                @Value("${countrySinger.lastName}") String lastName,
                                @Value("${countrySinger.birthDate}") DateTime birthdate,
                                @Value("${countrySinger.personalSite}") URL website) {
        return new Singer(firstName, lastName, birthdate, website);
    }


    @Bean
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        Set<Converter> convs = new HashSet<>();
        convs.add(converter());
        conversionServiceFactoryBean.setConverters(convs);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean;
    }

    @Bean
    public StringToDateTimeConverter converter() {
        StringToDateTimeConverter converter = new StringToDateTimeConverter();
        converter.setDatePattern(dateFormatPattern);
        converter.init();
        return converter;
    }
}
