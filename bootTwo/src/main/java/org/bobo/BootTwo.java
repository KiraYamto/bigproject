package org.bobo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("org.bobo.mybatis.mapper")
public class BootTwo {
    public static void main(String[] args) {
        System.out.println("------BootTwo Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(BootTwo.class,args);
        System.out.println("----------------------------");
        System.out.println("------BootTwo Finish----------");
    }
}
