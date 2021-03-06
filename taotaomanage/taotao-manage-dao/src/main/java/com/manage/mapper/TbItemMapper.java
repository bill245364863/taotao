package com.manage.mapper;

import com.manage.pojo.TbItem;
import com.manage.pojo.TbItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemMapper {
    long countByExample(TbItemQuery example);

    int deleteByExample(TbItemQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemQuery example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemQuery example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
}