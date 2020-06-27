package org.level.up.covid19.springcovid.repository.hibernate;

import org.level.up.covid19.springcovid.jpa.CountriesStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesStatusRepoSpringData extends JpaRepository<CountriesStatusEntity, String> {
}
