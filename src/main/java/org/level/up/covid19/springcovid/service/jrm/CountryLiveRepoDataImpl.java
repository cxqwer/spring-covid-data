package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.CountryCases;
import org.level.up.covid19.springcovid.jpa.CountryLiveEntity;
import org.level.up.covid19.springcovid.repository.hibernate.CountryLiveRepoSpringData;
import org.level.up.covid19.springcovid.repository.mybatis.CountryLiveRepoMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryLiveRepoDataImpl implements CountryLiveRepoData{

    @Autowired
    CountryLiveRepoSpringData countryLiveRepoSpringData;

    @Autowired
    CountryLiveRepoMyBatis countryLiveRepoMyBatis;

    @Override
    public void saveCountryLiveData(List<CountryCases> countryCasesList){
        countryLiveRepoMyBatis.truncateCountryLive();
        for (CountryCases countryCases : countryCasesList) {
            CountryLiveEntity countryLiveEntity = new CountryLiveEntity();
            countryLiveEntity.setCountryCode(countryCases.getCountryCode());
            countryLiveEntity.setCountry(countryCases.getCountry());
            countryLiveEntity.setCases(countryCases.getCases());
            countryLiveEntity.setDate(countryCases.getDate());
            countryLiveRepoSpringData.save(countryLiveEntity);
        }
    }

    @Override
    public List<CountryLiveEntity> getCountryLiveDataList(String countryName){
        return countryLiveRepoMyBatis.getCountryMyBatis(countryName);
    }

}
