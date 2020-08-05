package com.manage.service;

import com.taotao.common.EasyUITreeNod;

import java.util.List;

public interface ItemCatService {
    /*查询子节点列表*/
    List<EasyUITreeNod> getItemCatList(long parentId);
}
