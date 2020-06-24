package org.level.up.covid19.springcovid.service;

import lombok.Data;
import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.dto.CountriesStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.level.up.covid19.springcovid.utils.ClassPath.*;

@Data
@Service
public class CountryService {

    @Autowired
    private RestTemplate restTemplate;

    public Countries getCountry(String countryName) {
        List<Countries> listCountries = getCountriesList();
        for (Countries countries : listCountries) {
            if (countries.getCountry().equals(countryName))
                return countries;
        }
        return null;
    }

    public List<Countries> getCountriesList() {
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        ResponseEntity<Countries[]> responseEntity = restTemplate.exchange(BASE_URL + COUNTRIES_PATH,
                HttpMethod.GET, httpEntity, Countries[].class, 1);
        List<Countries> listCountries = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return listCountries;
    }

    public List<CountriesStatus> getCountriesStatusList(String countryName){
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        ResponseEntity<CountriesStatus[]> responseEntity = restTemplate.exchange(BASE_URL + ALL_STATUS_PATH + countryName,
                HttpMethod.GET, httpEntity, CountriesStatus[].class, 1);
        List<CountriesStatus> listCountriesStatus = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return listCountriesStatus;
    }
}
