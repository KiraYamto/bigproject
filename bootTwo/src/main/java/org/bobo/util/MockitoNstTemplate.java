package org.bobo.util;

import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.bobo.mybatis.query.NsNstTemplateQuery;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockitoNstTemplate implements iMockito<NsNstTemplateQuery,NsNstTemplateDto> {
    @Override
    public List<NsNstTemplateDto> selectList(NsNstTemplateQuery query) {
        List<NsNstTemplateDto> list = new ArrayList<>();
        for(int i=0;i<5;i++) {
            NsNstTemplateDto dto = Mockito.mock(NsNstTemplateDto.class);
            dto.setNstCode("NST-00" + i);
            dto.setNstName("bobotest" + i);
            boolean hitCode = dto.getNstCode() != null? dto.getNstCode().contains(query.getNstCode()):false;
            boolean hitName = dto.getNstName() != null? dto.getNstName().contains(query.getNstName()):false;
            if(hitCode||hitName){
                list.add(dto);
            }
        }
        return list;
    }
}
