package org.level.up.covid19.springcovid.jpa;

import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@ToString
@Table(name = "country_live", schema = "public", catalog = "covid")
public class CountryLiveEntity {
    private int id;
    private String countryCode;
    private String country;
    private int cases;
    private String date;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){ return id;}

    public void setId(int id){this.id =id;}

    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "cases")
    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLiveEntity that = (CountryLiveEntity) o;
        return cases == that.cases &&
                Objects.equals(id, that.id) &&
                Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(country, that.country) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryCode, country, cases, date);
    }
}
