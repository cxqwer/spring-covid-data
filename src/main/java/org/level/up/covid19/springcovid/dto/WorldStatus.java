package org.level.up.covid19.springcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
public class WorldStatus {

    @JsonProperty("NewConfirmed")
    private Integer newConfirmed;

    @JsonProperty("TotalConfirmed")
    private Integer totalConfirmed;

    @JsonProperty("NewDeaths")
    private Integer newDeaths;

    @JsonProperty("TotalDeaths")
    private Integer totalDeaths;

    @JsonProperty("NewRecovered")
    private Integer newRecovered;

    @JsonProperty("TotalRecovered")
    private Integer totalRecovered;

}
