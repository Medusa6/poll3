package com.briup.apps.poll3.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.apps.poll3.dao")
public class MybatisConfig {

}
