package org.bobo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerUtil {

    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerUtil.class);


    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;
    @Value("${spring.kafka.template.input-topic}")
    private String inputTopic;
    @Value("${spring.kafka.template.output-topic}")
    private String outputTopic;

    @KafkaListener(topics = "${spring.kafka.template.input-topic}",groupId = "${spring.kafka.consumer.group-id}")
    public void consumes(ConsumerRecord message) {
        Object value = message.value();
        System.out.println("bobo:"+message);
        if (value instanceof String) {
            logstashLogger.info("receive message from kafka topic {},and message is {}",inputTopic,value);
            logger.info("receive message from kafka topic {},and message is {}",inputTopic,value);
        }
        else if (value instanceof JSONObject) {
            logstashLogger.info("receive message from kafka topic {},and message is {}",inputTopic,JSONObject.toJSONString(value));
            logger.info("receive message from kafka topic {},and message is {}",inputTopic,JSONObject.toJSONString(value));
        }

    }



}
