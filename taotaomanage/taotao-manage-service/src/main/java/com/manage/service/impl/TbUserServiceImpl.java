/**
 * 公司：顶点信息
 * 文件名:TbUserServiceImpl
 * 作者:bill
 * 时间：2020/3/31 18:01
 * 描述：
 */
package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.mapper.TbUserMapper;
import com.manage.pojo.TbUser;
import com.manage.pojo.TbUserQuery;
import com.manage.service.TbUserService;
import com.taotao.common.LayuiParseDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper tbUserMapper;
    @Override
    public LayuiParseDataResult tbUserList(int page, int rows,String seletcKey) {
        TbUserQuery tbUserQuery = new TbUserQuery();
        LayuiParseDataResult layuiParseDataResult = new LayuiParseDataResult();
        if(seletcKey!=null && !("").equals(seletcKey)){
            //读取表从index开始到end
            //PageHelper.offsetPage(index,end);
            //设置分页信息
            PageHelper.startPage(page,rows);
            TbUserQuery.Criteria criteria = tbUserQuery.createCriteria();
            criteria.andUsernameEqualTo(seletcKey);
            List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserQuery);
            //取查询结果
            PageInfo<TbUser> pageInfo = new PageInfo<TbUser>(tbUsers);

            /*数量，总数*/
            layuiParseDataResult.setCount((int)pageInfo.getTotal());
            layuiParseDataResult.setCode(0);
            layuiParseDataResult.setMsg("获取数据成功");
            layuiParseDataResult.setData(tbUsers);
        }else{
            //设置分页信息
            PageHelper.startPage(page,rows);
            /*没有查询条件*/
            //TbUserQuery.Criteria criteria = tbUserQuery.createCriteria();
            List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserQuery);
            //取查询结果
            PageInfo<TbUser> pageInfo = new PageInfo<TbUser>(tbUsers);

            /*数量，总数*/
            layuiParseDataResult.setCount((int)pageInfo.getTotal());
            layuiParseDataResult.setCode(0);
            layuiParseDataResult.setMsg("获取数据成功");
            layuiParseDataResult.setData(tbUsers);
        }

        return layuiParseDataResult;
    }
}
