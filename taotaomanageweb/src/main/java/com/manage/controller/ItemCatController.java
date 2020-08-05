/**
 * 公司：顶点信息
 * 文件名:ItemCatController
 * 作者:bill
 * 时间：2020/3/28 22:02
 * 描述：
 */
package com.manage.controller;

import com.manage.service.ItemCatService;
import com.taotao.common.EasyUITreeNod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping("/item/cat/list")
    @ResponseBody
    //http://localhost:8081/item/cat/list?id=0
    //第一次请求的时候没有展开节点，id没有值则传0
    public List<EasyUITreeNod> getItemCatNod(@RequestParam(name = "id",defaultValue = "0") long parentId){
        List<EasyUITreeNod> treeNodList = itemCatService.getItemCatList(parentId);
    return treeNodList;
    }
}
