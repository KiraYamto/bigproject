package org.bobo.controller;

import com.alibaba.fastjson.JSON;
import org.bobo.mybatis.entity.NsNstTemplateDto;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class NsNstTemplateControllerTest {

    @Test
    public void getNsNstTemplateList() {
        List<NsNstTemplateDto> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(5);
        for(int i=1;i<=5;i++){
            NsNstTemplateDto dto1 = new NsNstTemplateDto();
            dto1.setNstCode("NST-00"+i);
            dto1.setNstName("bobotest"+i);
            Mockito.when(list.get(i)).thenReturn(dto1);
        }
        for(int i=0;i<list.size();i++){
            System.out.println(JSON.toJSONString(list.get(i)));
        }

    }

    @Test
    public void callBootTwo() {
    }
}