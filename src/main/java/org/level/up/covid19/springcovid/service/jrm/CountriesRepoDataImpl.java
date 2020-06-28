package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.level.up.covid19.springcovid.repository.hibernate.CountriesRepoSpringData;
import org.level.up.covid19.springcovid.repository.mybatis.CountriesRepoMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesRepoDataImpl implements CountriesRepoData {

    @Autowired
    CountriesRepoSpringData countriesRepoSpringData;

    @Autowired
    CountriesRepoMyBatis countriesRepoMyBatis;

    @Override
    public void saveCountriesSpringData(List<Countries> countries) {
        for (Countries country : countries) {
            CountriesEntity countryEntity = new CountriesEntity();
            countryEntity.setIso2(country.getISO2());
            countryEntity.setCountry(country.getCountry());
            countryEntity.setSlug(country.getSlug());
            countriesRepoSpringData.save(countryEntity);
        }
    }

    @Override
    public List<CountriesEntity> getListCountries() {
        return countriesRepoMyBatis.getCountriesMyBatis();
    }

    @Override
    public CountriesEntity getCountry(String countryName) {
        return countriesRepoMyBatis.getCountryMyBatis(countryName);
    }

}
