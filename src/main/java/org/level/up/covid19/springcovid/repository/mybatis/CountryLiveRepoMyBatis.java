package org.level.up.covid19.springcovid.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.level.up.covid19.springcovid.jpa.CountryLiveEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CountryLiveRepoMyBatis {

    @Select("select * from country_live where country = #{countryName}")
    List<CountryLiveEntity> getCountryMyBatis(@Param("countryName") String countryName);

    @Select("TRUNCATE country_live")
    void truncateCountryLive();
}
