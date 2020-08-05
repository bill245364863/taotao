package com.manage.mapper;

import com.manage.pojo.TbItemCat;
import com.manage.pojo.TbItemCatQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCatMapper {
    long countByExample(TbItemCatQuery example);

    int deleteByExample(TbItemCatQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    List<TbItemCat> selectByExample(TbItemCatQuery example);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemCat record, @Param("example") TbItemCatQuery example);

    int updateByExample(@Param("record") TbItemCat record, @Param("example") TbItemCatQuery example);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
}