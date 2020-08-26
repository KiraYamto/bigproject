package org.bobo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.bobo.service.impl.NsNstTemplateServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class NsNstTemplateController {

    public static final Logger logger = LoggerFactory.getLogger(NsNstTemplateController.class);
    @Autowired
    private NsNstTemplateServiceImpl nsNstTemplateService;
    @RequestMapping(value = {"/getNsNstTemplateList"}, method = RequestMethod.POST)
    public String getNsNstTemplateList(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        JSONObject json = JSON.parseObject(requestBody);
        String  nstName = json.getString("nstName");
        String  nstCode = json.getString("nstCode");

        List<NsNstTemplateDto> list = nsNstTemplateService.selectNsNstTemplateList(nstCode,nstName);
        String result = JSON.toJSONString(list);
        logger.debug("getNsNstTemplateList is {}",result);
        logger.info("getNsNstTemplateList is {}",result);
        logger.warn("getNsNstTemplateList is {}",result);
        logger.error("getNsNstTemplateList is {}",result);

        return result;
    }
}
