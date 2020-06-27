package org.level.up.covid19.springcovid.repository.hibernate;

import org.level.up.covid19.springcovid.jpa.WorldStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldStatusRepoSpringData extends JpaRepository<WorldStatusEntity, Integer> {
}
