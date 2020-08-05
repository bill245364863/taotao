/**
 * 公司：顶点信息
 * 文件名:ItemCatServiceImpl
 * 作者:bill
 * 时间：2020/3/28 19:35
 * 描述：
 */
package com.manage.service.impl;

import com.manage.mapper.TbItemCatMapper;
import com.manage.pojo.TbItemCat;
import com.manage.pojo.TbItemCatQuery;
import com.manage.service.ItemCatService;
import com.taotao.common.EasyUITreeNod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*商品分类管理*/
@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Override
    // {id: 290, text: "钟表", status: "closed"}
    public List<EasyUITreeNod> getItemCatList(long parentId) {
        //根据父节点id查询子节点列表
        TbItemCatQuery tbItemCatQuery = new TbItemCatQuery();
        //设置查询条件
        TbItemCatQuery.Criteria criteria =  tbItemCatQuery.createCriteria();
        //设置parentid值
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list =  tbItemCatMapper.selectByExample(tbItemCatQuery);
        //转换EasyUITreeNod列表
        List<EasyUITreeNod> treeNodList = new ArrayList<EasyUITreeNod>();
        for (TbItemCat tbItemCat: list) {
            EasyUITreeNod easyUITreeNod = new EasyUITreeNod();
            easyUITreeNod.setId(tbItemCat.getId());
            easyUITreeNod.setText(tbItemCat.getName());
            //如果节点下有子节点就是closed,如果没有子节点就是open
            String status = tbItemCat.getIsParent()?"closed":"open";
            easyUITreeNod.setState(status);
            treeNodList.add(easyUITreeNod);
        }
        return treeNodList;
    }
}
