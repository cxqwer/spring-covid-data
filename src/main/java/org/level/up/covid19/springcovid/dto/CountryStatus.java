package org.level.up.covid19.springcovid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CountryStatus {

    @JsonProperty("Country")
    private String country;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("Province")
    private String province;

    @JsonProperty("City")
    private String city;

    @JsonProperty("CityCode")
    private String cityCode;

    @JsonProperty("Lat")
    private String lat;

    @JsonProperty("Lon")
    private String lon;

    @JsonProperty("Confirmed")
    private Integer confirmed;

    @JsonProperty("Deaths")
    private Integer deaths;

    @JsonProperty("Recovered")
    private Integer recovered;

    @JsonProperty("Active")
    private Integer active;

    @JsonProperty("Date")
    private String date;

}
