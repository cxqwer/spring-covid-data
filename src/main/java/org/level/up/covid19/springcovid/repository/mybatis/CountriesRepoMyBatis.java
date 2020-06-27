package org.level.up.covid19.springcovid.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.level.up.covid19.springcovid.jpa.CountriesEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface CountriesRepoMyBatis {

    @Select("select * from countries where country = #{countryName}")
    CountriesEntity getCountryMyBatis(@Param("countryName") String countryName);

    @Select("select * from countries")
    List<CountriesEntity> getCountriesMyBatis();

}
