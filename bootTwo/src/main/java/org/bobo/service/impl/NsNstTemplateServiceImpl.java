package org.bobo.service.impl;

import com.alibaba.fastjson.JSON;
import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.bobo.mybatis.mapper.NsNstTemplateMapper;
import org.bobo.mybatis.query.NsNstTemplateQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsNstTemplateServiceImpl  {

    private final static Logger logger = LoggerFactory.getLogger(NsNstTemplateServiceImpl.class);

    @Autowired
    private NsNstTemplateMapper nsNstTemplateMapper;

    @CachePut(value ="cache-one")
    public List<NsNstTemplateDto> selectNsNstTemplateList(String nstCode, String nstName) {
        NsNstTemplateQuery query = new NsNstTemplateQuery(nstCode,nstName);
        List<NsNstTemplateDto> nstTemplateList = nsNstTemplateMapper.selectList(query);
        logger.debug("selectNsNstTemplateList responese : {}", JSON.toJSONString(nstTemplateList));
        logger.info("selectNsNstTemplateList responese : {}", JSON.toJSONString(nstTemplateList));
        logger.warn("selectNsNstTemplateList responese : {}", JSON.toJSONString(nstTemplateList));
        logger.error("selectNsNstTemplateList responese : {}", JSON.toJSONString(nstTemplateList));
        return nstTemplateList;
    }
}
