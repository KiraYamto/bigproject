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
        List<NsNstTemplateDto> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(5);
        for(int i=1;i<=5;i++){
            NsNstTemplateDto dto = new NsNstTemplateDto();
            dto.setNstCode("NST-00"+i);
            dto.setNstName("bobotest"+i);
            Mockito.when(list.get(i)).thenReturn(dto);
        }
        return list;
    }
}
