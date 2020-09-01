package org.bobo.service;

import org.bobo.mybatis.entity.NsNstTemplateDto;

import java.util.List;


public interface NsNstTemplateService {


    List<NsNstTemplateDto> selectNsNstTemplateList(String nstCode, String nstName);

}
