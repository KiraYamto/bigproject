package org.bobo.controller;

import org.bobo.util.KafkaConsumerUtil;
import org.bobo.util.KafkaProducerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    public static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    @Autowired
    private KafkaProducerUtil producer;
    private KafkaConsumerUtil comsumer;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;
    @Value("${spring.kafka.template.input-topic}")
    private String inputTopic;
    @Value("${spring.kafka.template.output-topic}")
    private String outputTopic;

    @RequestMapping(value = {"/send"}, method = RequestMethod.POST)
    public String syncSendMessage(@ApiIgnore @RequestBody String message, HttpServletRequest request, HttpServletResponse response){
        producer.syncSendMessage(inputTopic,message);
        return "ok";
    }

}
