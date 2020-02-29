package com.changgou.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 排除数据源的类，可以不用在配置文件中配置数据源信息
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class,args);
    }
}
