package org.level.up.covid19.springcovid.service;

import lombok.Data;
import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.dto.CountriesStatus;
import org.level.up.covid19.springcovid.dto.CountryCases;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.level.up.covid19.springcovid.utils.ClassPath.*;

@Data
@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Countries> getCountriesList() {
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        ResponseEntity<Countries[]> responseEntity = restTemplate.exchange(BASE_URL + COUNTRIES_PATH,
                HttpMethod.GET, httpEntity, Countries[].class, 1);
        List<Countries> listCountries = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return listCountries;
    }

    public List<CountriesStatus> getCountriesStatusList(String countryName) {
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        ResponseEntity<CountriesStatus[]> responseEntity = restTemplate.exchange(BASE_URL + ALL_STATUS_PATH + countryName,
                HttpMethod.GET, httpEntity, CountriesStatus[].class, 1);
        List<CountriesStatus> listCountriesStatus = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return listCountriesStatus;
    }

    public List<CountryCases> getLiveStatusDate(String countryName, String dateFrom, String dateTo) {
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        UriComponentsBuilder urlBuilder =
                UriComponentsBuilder.fromUriString(BASE_URL + TOTAL_PATH + COUNTRY_PATH + countryName + STATUS_CONFIRMED_PATH)
                        .queryParam("from", dateFrom)
                        .queryParam("to", dateTo);
        ResponseEntity<CountryCases[]> responseEntity =
                restTemplate.exchange(urlBuilder.toUriString(), HttpMethod.GET, httpEntity, CountryCases[].class, 1);
        List<CountryCases> countryCases = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return countryCases;
    }

    public Countries countryEntityToCountry(CountriesEntity countriesEntity) {
        Countries country = new Countries();
        country.setCountry(countriesEntity.getCountry());
        country.setISO2(countriesEntity.getIso2());
        country.setSlug(countriesEntity.getSlug());
        return country;
    }

    public List<Countries> countryEntityListToCountryList(List<CountriesEntity> countriesEntityList) {
        List<Countries> countryList = new ArrayList<>();
        countriesEntityList.forEach(e -> {
            countryList.add(countryEntityToCountry(e));
        });
        return countryList;
    }
}
