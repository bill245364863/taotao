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
import com.taotao.common.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public TaotaoResult addContentCategory(Long parentId, String categoryName) {
        //创建一个pojo
        TbContentCategory tbContentCategory = new TbContentCategory();
        //补全对象的属性
        tbContentCategory.setParentId(parentId);
        tbContentCategory.setName(categoryName);
        //'状态。可选值:1(正常),2(删除)
        tbContentCategory.setStatus(1);
        //排序默认为1
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setCreated(new Date());
        tbContentCategory.setUpdated(new Date());
        //插入到数据库
        contentCategoryMapper.insert(tbContentCategory);
        //判断父节点的状态,如果新增节点的父节点原来是子节点，需要修改父节点的状态
        TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
        if(!parent.getIsParent()){
            //如果父节点为叶子节点应该改为父节点
            parent.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parent);
        }
        //返回结果
        return TaotaoResult.ok(tbContentCategory);
    }

    @Override
    public void updateContentCategory(Long id, String name) {
        TbContentCategory tbContentCategory = contentCategoryMapper.selectByPrimaryKey(id);
        tbContentCategory.setName(name);
        contentCategoryMapper.updateByPrimaryKey(tbContentCategory);
    }

    @Override
    public void deleteContentCategory(Long id) {
        ArrayList<Long> objects = new ArrayList<Long>();
        objects.add(id);
        this.getId(objects,id);
        for(Long subId : objects){
            contentCategoryMapper.deleteByPrimaryKey(subId);
        }


    }

    private void getId(ArrayList<Long> ids ,Long id){

        TbContentCategoryQuery tbContentCategoryQuery = new TbContentCategoryQuery();
        TbContentCategoryQuery.Criteria criteria = tbContentCategoryQuery.createCriteria();
        criteria.andParentIdEqualTo(id);

        List<TbContentCategory> tbContentCategories = contentCategoryMapper.selectByExample(tbContentCategoryQuery);
        for (TbContentCategory tbContentCategory:tbContentCategories) {
            Long subId = tbContentCategory.getId();
            ids.add(subId);
            this.getId(ids,subId);
        }

    }
}
