package org.level.up.covid19.springcovid.repository.hibernate;

import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.level.up.covid19.springcovid.jpa.CountryLiveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLiveRepoSpringData extends JpaRepository<CountryLiveEntity, String> {
}
