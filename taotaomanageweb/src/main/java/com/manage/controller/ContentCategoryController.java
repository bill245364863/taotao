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
}
