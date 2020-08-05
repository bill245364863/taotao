/**
 * 公司：顶点信息
 * 文件名:ItemServiceImpl
 * 作者:bill
 * 时间：2020/3/8 18:17
 * 描述：
 */
package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.mapper.TbItemDescMapper;
import com.manage.mapper.TbItemMapper;
import com.manage.pojo.TbItem;
import com.manage.pojo.TbItemDesc;
import com.manage.pojo.TbItemQuery;
import com.manage.service.ItemService;
import com.taotao.common.EasyUIDataGridResult;
import com.taotao.common.IDUtils;
import com.taotao.common.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*商品管理服务service*/
@Service
public class ItemServiceImpl  implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Override
    public TbItem getItemById(long itemId) {
        /*查看商品信息*/
        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
        return item;
    }

    @Override
    public EasyUIDataGridResult getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page,rows);
        //执行查询
        TbItemQuery tbItemQuery = new  TbItemQuery();
        List<TbItem> list =  tbItemMapper.selectByExample(tbItemQuery);
        //取查询结果
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        EasyUIDataGridResult result =new EasyUIDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult addItem(TbItem tbItem,String desc) {
        //生成商品ID
        long itemId = IDUtils.genItemId();
        //补全tbitem的属性
        tbItem.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        tbItem.setStatus((byte) 1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        //向商品表插入数据
        tbItemMapper.insert(tbItem);
        //创建商品表述表对应的pojo
        TbItemDesc tbItemDesc = new TbItemDesc();
        //补全pojo的属性
        tbItemDesc.setItemId(itemId);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        tbItemDescMapper.insert(tbItemDesc);
        //返回结果
        return TaotaoResult.ok();
    }
}
