package com.wangfengbabe.demo.mybatis.mapper;

import com.wangfengbabe.demo.mybatis.model.Country;
import java.util.List;
import org.apache.ibatis.annotations.Flush;


public interface CountryMapper {
    List<Country> selectAll();

}
