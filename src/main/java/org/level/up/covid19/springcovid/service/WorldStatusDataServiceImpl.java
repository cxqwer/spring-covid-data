package org.level.up.covid19.springcovid.service;

import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.level.up.covid19.springcovid.jpa.WorldStatusEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldStatusDataServiceImpl implements WorldStatusDataService{

    @Autowired
    private WorldStatusRepoSpringData worldStatusRepoSpringData;

    @Override
    public void saveWorldStatusSpringData(WorldStatus worldStatus) {

    }

    @Override
    public WorldStatusEntity getWorldStatusEntity(Integer worldStatusId) {
        return null;
    }

}
