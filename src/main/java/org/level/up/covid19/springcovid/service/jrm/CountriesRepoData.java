package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.Countries;

import java.util.List;

public interface CountriesRepoData {

    void saveCountriesSpringData(List<Countries> countries);
}
