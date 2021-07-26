package kluszynski.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone extends AbstractEntity {
    @Id
    @GeneratedValue(generator = "phone_id_generator", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name = "phone_id_generator", sequenceName = "phone_seq", allocationSize = 1)
    private Long id;

    @Column(name = "COUNTRY_PREFIX")
    private String countryPrefix;

    private String number;

    // for JPA only
    protected Phone() {}

    public Phone(final String countryPrefix, final String number) {
        this.countryPrefix = countryPrefix;
        this.number = number;
    }

    public String getCountryPrefix() {
        return countryPrefix;
    }

    public void setCountryPrefix(final String countryPrefix) {
        this.countryPrefix = countryPrefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }
}
