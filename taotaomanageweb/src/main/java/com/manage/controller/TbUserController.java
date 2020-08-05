/**
 * 公司：顶点信息
 * 文件名:TbUserController
 * 作者:bill
 * 时间：2020/3/31 18:10
 * 描述：
 */
package com.manage.controller;

import com.manage.service.TbUserService;
import com.taotao.common.LayuiParseDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TbUserController {
    @Autowired
    private TbUserService tbUserService;
    @RequestMapping("/demo/table/user")
    @ResponseBody
    public LayuiParseDataResult getTbUserList(int page, int limit, @RequestParam(name = "key[username]",defaultValue = "")String selectKey){
        LayuiParseDataResult layuiParseDataResult = tbUserService.tbUserList(page, limit,selectKey);
        return layuiParseDataResult;
    }
    @RequestMapping("/demo")
    public String getTbUserTable(){
        return "layuitable";
    }
}
