package org.bobo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: bobo
 * @Date: 2020/11/24 9:59
 */
@RestController
@RequestMapping("/heart-beat")
public class HeartBeatController {

    public static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = {"/send"}, method = RequestMethod.GET)
    public String heartBeat(@RequestParam Long timestamp,@RequestParam String serverPath){
        return "ok";
    }
}
