package org.level.up.covid19.springcovid.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.ValidationResult;
import org.level.up.covid19.springcovid.dto.Countries;
import org.level.up.covid19.springcovid.dto.CountriesStatus;
import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.level.up.covid19.springcovid.service.CountryService;
import org.level.up.covid19.springcovid.service.WorldService;
import org.level.up.covid19.springcovid.service.jrm.WorldStatusDataServiceImpl;
import org.level.up.covid19.springcovid.utils.SchemaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class AppController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private SchemaValidator schemaValidator;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WorldService worldService;
    @Autowired
    WorldStatusDataServiceImpl worldStatusDataService;

    @Autowired


    /**
     * Метод возвращает название страны, сокращенное название и  ее код
     *
     * @param countyName Название
     * @return Json если страна есть или пустое тело при отсутствии страны
     */
    @GetMapping("/country")
    public @ResponseBody
    Countries getCountry(@RequestBody String countyName) {
        return countryService.getCountry(countyName);
    }

    /**
     * Метод возвращает список стран
     *
     * @return
     */
    @GetMapping("/countries")
    public @ResponseBody
    List<Countries> getCountryList() {
        return countryService.getCountriesList();
    }

    /**
     * Метод возвращает все данные по стране
     *
     * @param countyName название страны
     * @return
     */
    @GetMapping("/country/status")
    public @ResponseBody
    List<CountriesStatus> getCountriesStatusList(@RequestBody String countyName) {
        return countryService.getCountriesStatusList(countyName);
    }

    /**
     * Метод возвращает статистику по миру в указанный период времени
     *
     * @param dateFrom
     * @param dateTo
     * @return
     */
    @GetMapping("/world")
    public @ResponseBody
    List<WorldStatus> getCountriesStatusList(@RequestBody String dateFrom, String dateTo) {
        for (WorldStatus worldStatus : worldService.getWorldStatusList(dateFrom, dateTo)) {
            worldStatusDataService.saveWorldStatusSpringData(worldStatus);
        };
        return worldService.getWorldStatusList(dateFrom, dateTo);
    }


    /*
    Для примера
     */
    @PostMapping("/add")
    public @ResponseBody
    String addCountry(@RequestBody String raw) throws JsonProcessingException {
        ValidationResult validationResult = schemaValidator.validateSchema(raw, "src\\main\\resources\\shema\\Country.json");
        Set<ValidationMessage> message = validationResult.getValidationMessages();
        if (!message.isEmpty())
            return objectMapper.writeValueAsString(message);
        Countries countries = objectMapper.readValue(raw, Countries.class);
        return objectMapper.writeValueAsString(countries);
    }

}
