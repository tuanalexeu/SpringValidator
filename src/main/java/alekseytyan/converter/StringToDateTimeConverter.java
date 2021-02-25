package alekseytyan.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import javax.annotation.PostConstruct;

public class StringToDateTimeConverter implements Converter<String, DateTime> {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    private DateTimeFormatter dateFormat;
    private String datePattern = DEFAULT_DATE_PATTERN;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public DateTime convert(String s) {
        return dateFormat.parseDateTime(s);
    }

    @PostConstruct
    public void init() {
        dateFormat = DateTimeFormat.forPattern(datePattern);
    }
}
