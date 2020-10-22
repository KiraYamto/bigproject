package org.bobo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.bobo.mybatis.query.NsNstTemplateQuery;
import org.bobo.service.impl.NsNstTemplateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/second")
public class NsNstTemplateController {

    public static final Logger logger = LoggerFactory.getLogger(NsNstTemplateController.class);
    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    @Autowired
    private NsNstTemplateServiceImpl nsNstTemplateService;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = {"/getNsNstTemplateList"}, method = RequestMethod.POST)
    public String getNsNstTemplateList(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        logger.info("I am the second");
        logstashLogger.info("I am the second,request body is {}", JSON.toJSONString(requestBody));

        JSONObject json = JSON.parseObject(requestBody);
        String  nstName = json.getString("nstName");
        String  nstCode = json.getString("nstCode");

        List<NsNstTemplateDto> list = nsNstTemplateService.selectNsNstTemplateList(nstCode,nstName);
        //List<NsNstTemplateDto> list = nsNstTemplateService.selectNsNstTemplateListFromMock(nstCode,nstName);

        String result = JSON.toJSONString(list);
        logger.debug("getNsNstTemplateList is {}",result);
        logger.info("getNsNstTemplateList is {}",result);
        logger.warn("getNsNstTemplateList is {}",result);
        logger.error("getNsNstTemplateList is {}",result);
        logstashLogger.debug("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.info("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.warn("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.error("NsNstTemplateController getNsNstTemplateList is {}",result);
        return result;
    }

    @RequestMapping(value = {"/callBootOne"}, method = RequestMethod.POST)
    public String callBootOne(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        logger.info("I am the second,I will call callBootOne soon,requestbody is {}",requestBody);
        logstashLogger.info("I am the second,I will call callBootOne soon,requestbody is {}",requestBody);

        JSONObject json = JSON.parseObject(requestBody);
        String  nstName = json.getString("nstName");
        String  nstCode = json.getString("nstCode");
        NsNstTemplateQuery query = new NsNstTemplateQuery(nstCode,nstName);
        String url = "http://localhost:9010/first/getNsNstTemplateList";
        String result = restTemplate.postForObject(url,query,String.class);
        logger.info("I am callTwo and response is {}",result);
        logstashLogger.info("I am callTwo and response is {}",result);

        return result;
    }
}
