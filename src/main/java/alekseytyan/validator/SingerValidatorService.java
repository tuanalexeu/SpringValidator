package alekseytyan.validator;

import alekseytyan.entity.Singer;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class SingerValidatorService {

    private Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public Set<ConstraintViolation<Singer>> validateSinger(Singer singer) {
        return validator.validate(singer);
    }
}
