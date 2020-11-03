package org.bobo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/first")
@Api(description = "关于切片模板接口",value = "切片模板接口",tags = {"切片模板接口"})  //使用@Api来修饰类
public class NsNstTemplateController {

    public static final Logger logger = LoggerFactory.getLogger(NsNstTemplateController.class);
    public static final Logger logstashLogger = LoggerFactory.getLogger("LOGSTASH_LOGBACK");

    @Autowired
    private NsNstTemplateServiceImpl nsNstTemplateService;

    @Autowired
    private RestTemplate restTemplate;
    //private CloseableHttpClient httpClient;


    /*    @Api：修饰整个类，描述Controller的作用
    @ApiOperation：描述一个类的一个方法，或者说一个接
    @ApiParam：单个参数描述
    @ApiModel：用对象来接收参数
    @ApiProperty：用对象接收参数时，描述对象的一个字段
    @ApiResponse：HTTP响应其中1个描述
    @ApiResponses：HTTP响应整体描述
    @ApiIgnore：使用该注解忽略这个API
    @ApiError ：发生错误返回的信息
    @ApiImplicitParam：一个请求参数
    @ApiImplicitParams：多个请求参数*/
    @ApiOperation(value = "通过切片模板标识、模板名称查询切片模板",notes = "参数为切片模板标识nstCode、nstName")
    //使用ApiImplcitParam修饰接口参数

    @ApiImplicitParams({
            @ApiImplicitParam(name = "nstCode",value = "模板标识",paramType = "body",required = false),
            @ApiImplicitParam(name="nstName",value="模板名称",paramType = "body",required=false)
    })

    @RequestMapping(value = {"/getNsNstTemplateList"}, method = RequestMethod.POST)
    public String getNsNstTemplateList(@ApiIgnore @RequestBody NsNstTemplateQuery query, HttpServletRequest request, HttpServletResponse response){
        logger.info("I am the first,request body is {}", JSON.toJSONString(query));

        logstashLogger.info("I am the first,request body is {}", JSON.toJSONString(query));


        String  nstName = query.getNstName();
        String  nstCode = query.getNstCode();
        List<NsNstTemplateDto> list = nsNstTemplateService.selectNsNstTemplateList(nstCode,nstName);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = JSON.toJSONString(list);
        logger.debug("NsNstTemplateController getNsNstTemplateList is {}",result);
        logger.info("NsNstTemplateController getNsNstTemplateList is {}",result);
        logger.warn("NsNstTemplateController getNsNstTemplateList is {}",result);
        logger.error("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.debug("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.info("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.warn("NsNstTemplateController getNsNstTemplateList is {}",result);
        logstashLogger.error("NsNstTemplateController getNsNstTemplateList is {}",result);
        return result;
    }


    @RequestMapping(value = {"/callBootTwo"}, method = RequestMethod.POST)
    public String callBootTwo(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        logger.info("I am the first,I will call callBootTwo soon,requestbody is {}",requestBody);
        logstashLogger.info("I am the first,I will call callBootTwo soon,requestbody is {}",requestBody);

        String url = "http://localhost:9020/second/getNsNstTemplateList";
        String result = restTemplate.postForObject(url,requestBody,String.class);
        logger.info("I am callTwo and response is {}",result);
        logstashLogger.info("I am callTwo and response is {}",result);
        return result;
    }

}
