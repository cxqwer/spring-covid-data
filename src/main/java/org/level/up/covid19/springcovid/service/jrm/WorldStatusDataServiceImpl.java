package org.level.up.covid19.springcovid.service.jrm;

import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.level.up.covid19.springcovid.jpa.WorldStatusEntity;
import org.level.up.covid19.springcovid.repository.hibernate.WorldStatusRepoSpringData;
import org.level.up.covid19.springcovid.service.WorldStatusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorldStatusDataServiceImpl implements WorldStatusDataService {

    @Autowired
    private WorldStatusRepoSpringData worldStatusRepoSpringData;

    @Override
    public void saveWorldStatusSpringData(WorldStatus worldStatus) {
        WorldStatusEntity worldStatusEntity = new WorldStatusEntity();
        worldStatusEntity.setNewConfirmed(worldStatus.getNewConfirmed());
        worldStatusEntity.setNewDeaths(worldStatus.getNewDeaths());
        worldStatusEntity.setTotalDeaths(worldStatus.getTotalDeaths());
        worldStatusEntity.setNewRecovered(worldStatus.getNewRecovered());
        worldStatusEntity.setTotalRecovered(worldStatus.getTotalRecovered());
        worldStatusRepoSpringData.save(worldStatusEntity);
    }

    @Override
    public WorldStatusEntity getWorldStatusEntity(Integer worldStatusId) {
        return null;
    }

}
