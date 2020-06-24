package org.level.up.covid19.springcovid.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CountryEnum {
    Russia("Russian Federation","russia","RU"),
    Germany("Germany", "germany", "DE"),
    USA("United States of America", "united-states", "US"),
    ;

public String Country;
public String Slug;
public String ISO2;

}
