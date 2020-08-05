/**
 * 公司：顶点信息
 * 文件名:ShowIndecController
 * 作者:bill
 * 时间：2020/5/29 22:50
 * 描述：
 */
package com.manage.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowIndexController {
    @RequestMapping("/index")
    public  String showIndexPage(){
        return "index";
    }
}
