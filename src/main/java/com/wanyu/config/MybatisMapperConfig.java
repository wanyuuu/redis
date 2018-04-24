package com.wanyu.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by samsung on 2018/1/13.
 */
@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MybatisMapperConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mscf=new MapperScannerConfigurer();
        mscf.setBasePackage("com.wanyu.mapper");
        mscf.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mscf;
    }
}
