package org.bobo.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class KafkaProducerUtil implements iMqUtil{

    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerUtil.class);
    @Autowired
    private KafkaTemplate<String,String> producerKafkaTemplate;




    @Override
    public <T> void syncSendMessage(String topic, T message) {
        if (message instanceof String) {
            this.producerKafkaTemplate.send(topic, (String) message);
            logger.info("send message to kafka topic {},and message is {}",topic,message);
            logstashLogger.info("send message to kafka topic {},and message is {}",topic,message);
        }
        else if (message instanceof JSONObject) {
            this.producerKafkaTemplate.send(topic, JSONObject.toJSONString(message));
            logger.info("send message to kafka topic {},and message is {}",topic,JSONObject.toJSONString(message));
            logstashLogger.info("send message to kafka topic {},and message is {}",topic,JSONObject.toJSONString(message));
        }

    }

    @Override
    public <T> void syncSendMessage(String topic, String key, T message) {
        if (message instanceof String) {
            this.producerKafkaTemplate.send(topic, key,(String) message);
            logger.info("send message to kafka topic {},and message is {}",topic,message);
            logstashLogger.info("send message to kafka topic {},and message is {}",topic,message);
        }
        else if (message instanceof JSONObject) {
            this.producerKafkaTemplate.send(topic, key,JSONObject.toJSONString(message));
            logger.info("send message to kafka topic {},and message is {}",topic,JSONObject.toJSONString(message));
            logstashLogger.info("send message to kafka topic {},and message is {}",topic,JSONObject.toJSONString(message));
        }
    }

    /*同步发送*/
    /*public String syncSendMessage(String topic,String message){
        try {
            kafkaTemplate.send(topic,message);
        }catch (Exception e){
            logger.error("send message to kafka topic {} occur an error! error msg is {}",topic,e);
            return null;
        }
        logstashLogger.info("send message to kafka topic {},and message is {}",topic,message);
        logger.info("send message to kafka topic {},and message is {}",topic,message);
        return null;
    }*/



}
