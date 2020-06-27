package org.level.up.covid19.springcovid.service;

import lombok.Data;
import lombok.ToString;
import org.level.up.covid19.springcovid.dto.CountriesStatus;
import org.level.up.covid19.springcovid.dto.CountryCases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString
public class CountriesIntervalData {

    private String country;
    private String dateFrom;
    private String dateTo;
    private Integer newConfirmed;
    private Double averageNewConfirmed;

    public CountriesIntervalData(List<CountryCases> countryCases) {
        country = countryCases.get(0).getCountry();
        dateFrom = countryCases.get(0).getDate();
        dateTo = countryCases.get(countryCases.size() - 1).getDate();

        List<Integer> confirmList = countryCases
                .stream()
                .map(CountryCases::getCases)
                .collect(Collectors.toCollection(ArrayList::new));

        newConfirmed = confirmList.get(confirmList.size() - 1) - confirmList.get(0);

        //Расчет среднего значения новых заражений(медиана), в указаный период времени
        List<Integer> newConfirmList = new ArrayList<>();
        for (int i = 1; i < confirmList.size(); i++) {
            newConfirmList.add(confirmList.get(i) - confirmList.get(i - 1));
        }
        Collections.sort(newConfirmList);
        averageNewConfirmed = (newConfirmList.get(newConfirmList.size() / 2 - 1) + newConfirmList.get(newConfirmList.size() / 2 + 1)) * 0.5;
    }

}
