package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext-*.xml");
        TbItemMapper mapper = context.getBean(TbItemMapper.class);
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> list = mapper.selectByExample(example);
        for (TbItem item : list){
            System.out.println(item.getTitle());
        }
        PageInfo<TbItem> info = new PageInfo<>(list);
        System.out.println(info.getTotal());
    }
}
