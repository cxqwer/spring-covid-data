package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.CountryCases;
import org.level.up.covid19.springcovid.jpa.CountryLiveEntity;

import java.util.List;

public interface CountryLiveRepoData {

    void saveCountryLiveData(List<CountryCases> countryCasesList);
    public List<CountryLiveEntity> getCountryLiveDataList(String countryName);
}
