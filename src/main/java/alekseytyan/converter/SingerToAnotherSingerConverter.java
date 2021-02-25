package alekseytyan.converter;

import alekseytyan.entity.AnotherSigner;
import alekseytyan.entity.Singer;
import org.springframework.core.convert.converter.Converter;

public class SingerToAnotherSingerConverter implements Converter<Singer, AnotherSigner> {
    @Override
    public AnotherSigner convert(Singer singer) {
        return new AnotherSigner(
                singer.getFirstName(),
                singer.getLastName(),
                singer.getBirthdate(),
                singer.getPersonalSite()
        );
    }
}
