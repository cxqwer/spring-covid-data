package org.level.up.covid19.springcovid.jpa;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "public", catalog = "covid")
public class CountriesEntity {
    private String country;
    private String slug;
    private String iso2;

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Id
    @Column(name = "iso2")
    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesEntity that = (CountriesEntity) o;
        return Objects.equals(country, that.country) &&
                Objects.equals(slug, that.slug) &&
                Objects.equals(iso2, that.iso2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, slug, iso2);
    }

}
