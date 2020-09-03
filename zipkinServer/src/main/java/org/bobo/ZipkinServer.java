package org.bobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication(scanBasePackages = "org.bobo")
@EnableDiscoveryClient
@EnableZipkinServer
public class ZipkinServer {

    public static void main(String[] args) {
        System.out.println("------ZipkinServer Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(ZipkinServer.class,args);
        System.out.println("----------------------------");
        System.out.println("------ZipkinServer Finish----------");
    }
}
