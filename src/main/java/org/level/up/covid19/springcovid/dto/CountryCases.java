package org.level.up.covid19.springcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CountryCases {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Lat")
    private String lat;

    @JsonProperty("Lon")
    private String lon;

    @JsonProperty("Cases")
    private Integer cases;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Date")
    private String date;

}
