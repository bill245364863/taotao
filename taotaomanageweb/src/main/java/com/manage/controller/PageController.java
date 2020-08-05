/**
 * 公司：顶点信息
 * 文件名:PageController
 * 作者:bill
 * 时间：2020/3/16 22:45
 * 描述：
 */
package com.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//页面展示
@Controller
public class PageController {
         /*首页*/
        @RequestMapping("/")
        public String showIndex(){
            return "index";
        }

        /*页面跳转*/
        @RequestMapping("/{page}")
         public String getPage(@PathVariable String page){
            return  page;
        }


}
