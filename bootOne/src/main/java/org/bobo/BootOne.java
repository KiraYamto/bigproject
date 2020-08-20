package org.bobo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootOne {
    public static void main(String[] args) {
        System.out.println("------BootOne Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(BootOne.class,args);
        System.out.println("----------------------------");
        System.out.println("------BootOne Finish----------");
    }
}
