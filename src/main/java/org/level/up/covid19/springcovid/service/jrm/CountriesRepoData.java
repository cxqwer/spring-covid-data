package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;

import java.util.List;

public interface CountriesRepoData {

    void saveCountriesSpringData(List<Countries> countries);

    List<CountriesEntity> getListCountries();

    CountriesEntity getCountry(String countryName);
}
