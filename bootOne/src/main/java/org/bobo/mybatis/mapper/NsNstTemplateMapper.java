package org.bobo.mybatis.mapper;


import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.bobo.mybatis.query.NsNstTemplateQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NsNstTemplateMapper {

    List<NsNstTemplateDto> selectList(NsNstTemplateQuery query);

}
