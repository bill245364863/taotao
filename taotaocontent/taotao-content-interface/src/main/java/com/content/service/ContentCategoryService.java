package com.content.service;

import com.taotao.common.EasyUITreeNod;

import java.util.List;

public interface ContentCategoryService {
    List<EasyUITreeNod> getContentCategoryList(long parentId);
}
