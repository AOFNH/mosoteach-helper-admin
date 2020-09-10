package com.mshelper.dms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Bellamy
 */
@SpringBootApplication
@EnableSwagger2
//@MapperScans(@MapperScan(value = "com.mshelper.dms.dao"))
@MapperScan("com.mshelper.dms.dao")
public class DmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmsApplication.class, args);
    }

}
