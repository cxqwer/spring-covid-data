package org.level.up.covid19.springcovid.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "countries_status", schema = "public", catalog = "covid")
public class CountriesStatusEntity {
    private String country;
    private String lat;
    private String lon;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private Integer active;
    private String date;
    private String locationId;
    private CountriesEntity countriesByCountryCode;

    @Id
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "lat")
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lon")
    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Basic
    @Column(name = "confirmed")
    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "deaths")
    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    @Basic
    @Column(name = "recovered")
    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    @Basic
    @Column(name = "active")
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "locationID")
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesStatusEntity that = (CountriesStatusEntity) o;
        return Objects.equals(country, that.country) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lon, that.lon) &&
                Objects.equals(confirmed, that.confirmed) &&
                Objects.equals(deaths, that.deaths) &&
                Objects.equals(recovered, that.recovered) &&
                Objects.equals(active, that.active) &&
                Objects.equals(date, that.date) &&
                Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, lat, lon, confirmed, deaths, recovered, active, date, locationId);
    }

    @ManyToOne
    @JoinColumn(name = "country_code", referencedColumnName = "iso2", nullable = false)
    public CountriesEntity getCountriesByCountryCode() {
        return countriesByCountryCode;
    }

    public void setCountriesByCountryCode(CountriesEntity countriesByCountryCode) {
        this.countriesByCountryCode = countriesByCountryCode;
    }
}
