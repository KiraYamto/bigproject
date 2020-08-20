package org.bobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(scanBasePackages = {"org.bobo"})
@EnableEurekaServer
public class EurekaServer {

    public static void main(String[] args) {
        System.out.println("------Eureka Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(EurekaServer.class,args);
        System.out.println("----------------------------");
        System.out.println("------Eureka Finish----------");

    }
}
