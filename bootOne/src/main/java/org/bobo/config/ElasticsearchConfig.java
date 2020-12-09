package org.bobo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bobo
 * @Date: 2020/11/27 14:30
 */

//RestClientAutoConfiguration 代替，springboot自带
@Configuration
public class ElasticsearchConfig {

    @Value("${elasticsearch.hosts}")
    private String hostAndPort;

    @Bean
    public RestHighLevelClient getClient() {
        RestHighLevelClient client = null;
        List<HttpHost> httpHosts = new ArrayList<HttpHost>();
        String[] hostsAndPortArr = hostAndPort.split(",");
        if (hostsAndPortArr.length > 0) {
            for (String hostsAndPort : hostsAndPortArr) {
                String[] hp = hostsAndPort.split(":");
                httpHosts.add(new HttpHost(hp[0], Integer.valueOf(hp[1]), "http"));
            }
            client = new RestHighLevelClient(RestClient.builder(httpHosts.toArray(new HttpHost[0])));
        } else {
            client = new RestHighLevelClient(
                    RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
        }

        return client;
    }
}
