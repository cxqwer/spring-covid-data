package org.level.up.covid19.springcovid.service;

import lombok.Data;
import org.level.up.covid19.springcovid.dto.WorldStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.level.up.covid19.springcovid.utils.ClassPath.*;

@Data
@Service
public class WorldService {

    @Autowired
    private RestTemplate restTemplate;

    public List<WorldStatus> getWorldStatusList(String dateFrom, String dateTo){
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(BASE_URL + WORLD_PATH)
                .queryParam("from", dateFrom)
                .queryParam("to", dateTo);
        ResponseEntity<WorldStatus[]> responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                HttpMethod.GET, httpEntity, WorldStatus[].class, 1);
        List<WorldStatus> worldStatusList = new ArrayList<>(Arrays.asList(responseEntity.getBody()));
        return worldStatusList;
    }
}
