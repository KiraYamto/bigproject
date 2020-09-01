package org.bobo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "org.bobo")
@EnableDiscoveryClient
@MapperScan("org.bobo.mybatis.mapper")
public class BootOne {
    public static void main(String[] args) {
        System.out.println("------BootOne Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(BootOne.class,args);
        System.out.println("----------------------------");
        System.out.println("------BootOne Finish----------");
    }
}
