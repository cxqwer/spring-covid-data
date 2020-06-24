package org.level.up.covid19.springcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class Countries {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Slug")
    private String slug;

    @JsonProperty("ISO2")
    private String iSO2;

}
