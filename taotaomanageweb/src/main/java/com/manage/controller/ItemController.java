/**
 * 公司：顶点信息
 * 文件名:ItemController
 * 作者:bill
 * 时间：2020/3/8 19:46
 * 描述：
 */
package com.manage.controller;

import com.manage.pojo.TbItem;
import com.manage.service.ItemService;
import com.taotao.common.EasyUIDataGridResult;
import com.taotao.common.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
      TbItem item = itemService.getItemById(itemId);
        return item;
    }
    /*查看商品列表*/
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList(int page, int rows){
        EasyUIDataGridResult   easyUIDataGridResult  = itemService.getItemList(page, rows);
        return easyUIDataGridResult;
    }
    @RequestMapping(value = "/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addItem(TbItem tbItem,String desc){
        TaotaoResult taotaoResult = itemService.addItem(tbItem, desc);
        return taotaoResult;
    }
}
