package org.bobo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication(scanBasePackages = "org.bobo",exclude={ElasticsearchAutoConfiguration.class, RestClientAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("org.bobo.mybatis.mapper")
public class BootOne {

    public static final ExecutorService executor = Executors.newSingleThreadExecutor();
    public static void main(String[] args) {
        System.out.println("------BootOne Start----------");
        System.out.println("----------------------------");
        SpringApplication.run(BootOne.class,args);
        System.out.println("----------------------------");
        System.out.println("------BootOne Finish----------");
      /*  ZkMonitor task = new ZkMonitor();
        executor.submit(task);*/
    }
}
