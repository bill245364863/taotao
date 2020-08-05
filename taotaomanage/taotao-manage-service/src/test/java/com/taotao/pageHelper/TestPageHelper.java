/**
 * 公司：顶点信息
 * 文件名:TestPageHelper
 * 作者:bill
 * 时间：2020/3/22 21:08
 * 描述：
 */
package com.taotao.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.mapper.TbItemMapper;
import com.manage.pojo.TbItem;
import com.manage.pojo.TbItemQuery;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    @Test
    public void testPageHelper() throws Exception{
        //先mybatis的配置文件中配置分页插件
        //在执行查询之前配置分页条件，使用pagehelper的静态方法
        PageHelper.startPage(1,20);
        //执行查询
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //创建exmple对对象
        TbItemQuery tbItemQuery =new TbItemQuery();
        //查询条件
        //TbItemQuery.Criteria  CriteriaCriteria = tbItemQuery.createCriteria();
        //CriteriaCriteria.andIdEqualTo(562379L);
         List<TbItem> list = tbItemMapper.selectByExample(tbItemQuery);
        //取分页信息，使用pageinfo对象取。
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println("查询总记录数："+ pageInfo.toString());
        System.out.println("查询总记录数："+ pageInfo.getTotal());
        System.out.println("查询总页数："+pageInfo.getPages());
        System.out.println("放回的记录数："+list.size());

    }
}
