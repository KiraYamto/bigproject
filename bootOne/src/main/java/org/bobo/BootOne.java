package org.bobo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

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
