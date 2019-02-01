package com.wangfengbabe.demo.mybatis.mapper;

import static org.junit.Assert.*;

import com.wangfengbabe.demo.mybatis.model.Country;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountryMapperTest {

    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {

        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
//            List<Country> list = session.selectList("selectAll");
            CountryMapper mapper = session.getMapper(CountryMapper.class);
            List<Country> list = mapper.selectAll();
            list.stream().forEach(System.out::print);


        } finally {
            session.close();

        }
    }

}