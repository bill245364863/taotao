package com.manage.service;

import com.taotao.common.LayuiParseDataResult;

public interface TbUserService {
    /*查看tbuser列表*/
    LayuiParseDataResult tbUserList(int page, int rows,String seletcKey);

}
