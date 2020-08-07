/**
 * 公司：
 * 文件名:ContentCategoryController
 * 作者:bill
 * 时间：2020/7/28 23:18
 * 描述：
 */
package com.manage.controller;

import com.content.service.ContentCategoryService;
import com.taotao.common.EasyUITreeNod;
import com.taotao.common.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNod> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") long parentId){
        List<EasyUITreeNod> contentCategoryList = contentCategoryService.getContentCategoryList(parentId);
        return contentCategoryList;
    }

    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId,String name){
        TaotaoResult taotaoResult = contentCategoryService.addContentCategory(parentId, name);
        return taotaoResult;

    }

    @RequestMapping("/content/category/update")
    @ResponseBody
    public  void updateContentCategory(Long id,String name){
        contentCategoryService.updateContentCategory(id,name);
    }

    @RequestMapping("/content/category/delete")
    @ResponseBody
    public void deleteContentCategory(Long id){
        contentCategoryService.deleteContentCategory(id);
    }
}
