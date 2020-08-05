/**
 * 公司：顶点信息
 * 文件名:ItemService
 * 作者:bill
 * 时间：2020/3/8 18:12
 * 描述：
 */
package com.manage.service;

import com.manage.pojo.TbItem;
import com.taotao.common.EasyUIDataGridResult;
import com.taotao.common.TaotaoResult;

public  interface ItemService {
    /*根据商品id查询商品信息*/
    TbItem getItemById(long itemId);
    /*查询商品列表*/
    EasyUIDataGridResult getItemList(int page,int rows);
    /*添加商品信息*/
    TaotaoResult addItem(TbItem tbItem,String desc);
}
