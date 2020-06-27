package org.level.up.covid19.springcovid.service;

import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.level.up.covid19.springcovid.jpa.WorldStatusEntity;

public interface WorldStatusDataService {

    void saveWorldStatusSpringData(WorldStatus worldStatus);

    WorldStatusEntity getWorldStatusEntity(Integer worldStatusId);
}
