package org.level.up.covid19.springcovid.controller;

import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.dto.CountryStatus;
import org.level.up.covid19.springcovid.dto.CountryCases;
import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.level.up.covid19.springcovid.jpa.CountryLiveEntity;
import org.level.up.covid19.springcovid.service.CountriesIntervalData;
import org.level.up.covid19.springcovid.service.CountryService;
import org.level.up.covid19.springcovid.service.WorldService;
import org.level.up.covid19.springcovid.service.jrm.CountriesRepoDataImpl;
import org.level.up.covid19.springcovid.service.jrm.CountryLiveRepoDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private WorldService worldService;

    @Autowired
    private CountriesRepoDataImpl countriesRepoSpringData;

    @Autowired
    CountryLiveRepoDataImpl countryLiveRepoData;

    /**
     * метод обновляет список стран в БДД
     * @return
     */
    @GetMapping("/countries/update")
    public @ResponseBody
    List<Countries> updateCounties() {
        countriesRepoSpringData.saveCountriesSpringData(countryService.getCountriesList());
        List<CountriesEntity> countriesEntityList = countriesRepoSpringData.getListCountries();
        return countryService.countryEntityListToCountryList(countriesEntityList);
    }

    /**
     * метод выводит список стран из БД
     * @return
     */
    @GetMapping("/countries")
    public @ResponseBody
    List<Countries> getCounties() {
        List<CountriesEntity> countriesEntityList = countriesRepoSpringData.getListCountries();
        return countryService.countryEntityListToCountryList(countriesEntityList);
    }

    /**
     * метод выводит страну из БД
     * @param countryName
     * @return
     */
    @GetMapping("/country")
    public @ResponseBody
    Countries getCountry(@RequestParam("Country") String countryName) {
        CountriesEntity countriesEntity = countriesRepoSpringData.getCountry(countryName);
        return countryService.countryEntityToCountry(countriesEntity);
    }

    /**
     * метод выводит список данных по стране за весь период наблюдений
     * @param countryName
     * @return
     */
    @GetMapping("/country/countryStatus")
    public @ResponseBody
    List<CountryStatus> getCountriesStatusList(@RequestParam("Country") String countryName) {
        return countryService.getCountriesStatusList(countryName);
    }

    /**
     * метод выводит информацию по миру
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @GetMapping("/world")
    public @ResponseBody
    List<WorldStatus> getCountriesStatusList(@RequestParam("dateFrom") String dateFrom, @RequestParam("dateTo") String dateTo) {
        return worldService.getWorldStatusList(dateFrom, dateTo);
    }

    /**
     * метод выводит среднее значение новых заболевших страны и общее количество заболевших в период
     * @param countryName
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @GetMapping("/country/liveDate")
    public @ResponseBody
    CountriesIntervalData getCountriesIntervalData(@RequestParam("Country") String countryName,
                                                   @RequestParam("dateFrom") String dateFrom,
                                                   @RequestParam("dateTo") String dateTo) {
        List<CountryCases> countryServices = countryService.getLiveStatusDate(countryName, dateFrom, dateTo);
        return new CountriesIntervalData(countryServices);
    }

    /**
     * Метод обновляет данные по стране в таблице
     * @param countryName
     * @return сохраненный данные из таблицы
     */
    @GetMapping("/countryLive/Update")
    public @ResponseBody
    List<CountryLiveEntity> updateCountryLive(@RequestParam("country") String countryName){
        List<CountryCases> countryCasesList = countryService.getLiveStatusDate(countryName);
        countryLiveRepoData.saveCountryLiveData(countryCasesList);
        return countryLiveRepoData.getCountryLiveDataList(countryName);
    }

    /**
     * Метод возвращает данные по стране из таблицы
     * @param countryName
     * @return
     */
    @GetMapping("/countryLive")
    public @ResponseBody
    List<CountryLiveEntity> getCountryLive(@RequestParam("country") String countryName){
        return countryLiveRepoData.getCountryLiveDataList(countryName);
    }


}
