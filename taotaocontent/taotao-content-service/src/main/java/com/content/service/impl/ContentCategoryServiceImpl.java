/**
 * 公司：
 * 文件名:ContentCategoryServiceImpl
 * 作者:bill
 * 时间：2020/7/28 23:05
 * 描述：
 */
package com.content.service.impl;

import com.content.service.ContentCategoryService;
import com.manage.mapper.TbContentCategoryMapper;
import com.manage.pojo.TbContentCategory;
import com.manage.pojo.TbContentCategoryQuery;
import com.taotao.common.EasyUITreeNod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<EasyUITreeNod> getContentCategoryList(long parentId) {

        //根据parentid查询子节点列表
        TbContentCategoryQuery tbContentCategoryQuery = new TbContentCategoryQuery();
        //设置查询条件
        TbContentCategoryQuery.Criteria criteria = tbContentCategoryQuery.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(tbContentCategoryQuery);
        ArrayList<EasyUITreeNod> easyUITreeNods = new ArrayList<>();
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            EasyUITreeNod easyUITreeNod = new EasyUITreeNod();
            easyUITreeNod.setId(tbContentCategory.getId());
            easyUITreeNod.setText(tbContentCategory.getName());
            easyUITreeNod.setState(tbContentCategory.getIsParent() ? "closed" : "open");
            //添加到结果
            easyUITreeNods.add(easyUITreeNod);
        }
        return easyUITreeNods;
    }
}
