package alekseytyan.entity;

import org.joda.time.DateTime;

import javax.validation.constraints.*;
import java.net.URL;
import java.text.SimpleDateFormat;

public class Singer {

    @NotNull
    @Size(min=2, max=60)
    private String firstName;

    private String lastName;
    private Genre genre;
    private Gender gender;
    private DateTime birthdate;
    private URL personalSite;

    public Singer(String firstName, String lastName, DateTime birthdate, URL personalSite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.personalSite = personalSite;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }

    public URL getPersonalSite() {
        return personalSite;
    }

    public void setPersonalSite(URL personalSite) {
        this.personalSite = personalSite;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return String.format("{" +
                        "First name: %s, " +
                        "Last name: %s, " +
                        "Birthday: %s, " +
                        "Site: %s" +
                        "}",
                firstName,
                lastName,
                sdf.format(birthdate.toDate()),
                personalSite);
    }
}
