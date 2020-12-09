package org.bobo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bobo.util.elasticsearch.ElasticsearchClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: bobo
 * @Date: 2020/12/1 9:43
 */
@RestController
@RequestMapping("/es")
public class ElasticsearchController {

    public static final Logger logger = LoggerFactory.getLogger(ElasticsearchController.class);
    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    @Autowired
    private ElasticsearchClient client;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public String send(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        String _id = UUID.randomUUID().toString();
        JSONObject json = JSON.parseObject(requestBody);
        String  _index = json.getString("index");
        String  _type = json.getString("type");
        String _source = json.getString("source");
        JSONObject jsonSource = JSON.parseObject(_source);

        Map<String,Object> dataMap = JSON.parseObject(_source);
        try {
            client.execIndex(_index,_type,_id,dataMap);
        } catch (IOException e) {
            logger.error("exception",e);
        }
        return "ok";
    }

    private void test(){
        redisTemplate.getRequiredConnectionFactory().getConnection().info("memory");
    }

    public static void main(String[] args) {
        String tt = " {\n" +
                "        \"ORG_SEVERITY\": \"99040\",\n" +
                "        \"ORG_OBJECT_TYPE\": \"99006\",\n" +
                "        \"PHD_FP\": \"1728709785335388\",\n" +
                "        \"ORG_NE_UID\": \"202092312\",\n" +
                "        \"OmcAlarmId\": \"1728709785335388\",\n" +
                "        \"ORG_LOCATION_INFO\": \"\",\n" +
                "        \"PHD_ALARM_SOURCE\": \"1\",\n" +
                "        \"ORG_ADDITIONAL_INFO\": \"\",\n" +
                "        \"ORG_ALARM_STATUS\": \"1\",\n" +
                "        \"PHD_ALARM_SIGNAL\": \"1728709785335388\",\n" +
                "        \"OPER_TYPE\": \"1406\",\n" +
                "        \"PHD_GID\": \"202092312\",\n" +
                "        \"ORG_ALARM_TYPE\": \"1\",\n" +
                "        \"PHD_C_FP\": \"1728709785335388\",\n" +
                "        \"ORG_OBJECT_NAME\": \"ZTEENodeB12\",\n" +
                "        \"ORG_SPECIFIC_PROBLEM\": \"基站退出服务\",\n" +
                "        \"ORG_EVENT_TIME\": \"2020-11-30 15:51:15\",\n" +
                "        \"ORG_OBJECT_UID\": \"202092312\",\n" +
                "        \"ORG_ALARM_ID\": \"1728709785335388\",\n" +
                "        \"ORG_NE_TYPE\": \"99006\",\n" +
                "        \"ORG_ALARM_TITLE\": \"基站退出服务\",\n" +
                "        \"TimeStamp\": 1606722675096,\n" +
                "        \"ORG_CLEAR_TIME\": \"\",\n" +
                "        \"STD_SPECIALTY_TYPE\": \"103\",\n" +
                "        \"EventTime\": \"2020-11-30 15:51:15\",\n" +
                "        \"PHD_VENDOR_ID\": \"55001\",\n" +
                "        \"ORG_SPECIFIC_PROBLEM_ID\": \"198094833\",\n" +
                "        \"ORG_NE_NAME\": \"ZTEENodeB12\"\n" +
                "    }";
        Map<String,Object> map = JSON.parseObject(tt);
        System.out.println(map);
    }
}
