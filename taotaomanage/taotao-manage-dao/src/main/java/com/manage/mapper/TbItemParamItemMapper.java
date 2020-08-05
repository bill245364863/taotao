package com.manage.mapper;

import com.manage.pojo.TbItemParamItem;
import com.manage.pojo.TbItemParamItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemParamItemMapper {
    long countByExample(TbItemParamItemQuery example);

    int deleteByExample(TbItemParamItemQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    List<TbItemParamItem> selectByExampleWithBLOBs(TbItemParamItemQuery example);

    List<TbItemParamItem> selectByExample(TbItemParamItemQuery example);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemQuery example);

    int updateByExampleWithBLOBs(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemQuery example);

    int updateByExample(@Param("record") TbItemParamItem record, @Param("example") TbItemParamItemQuery example);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);
}