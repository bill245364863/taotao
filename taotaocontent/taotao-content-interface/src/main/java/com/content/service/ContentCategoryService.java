package com.content.service;

import com.taotao.common.EasyUITreeNod;
import com.taotao.common.TaotaoResult;

import java.util.List;

public interface ContentCategoryService {

    List<EasyUITreeNod> getContentCategoryList(long parentId);

    TaotaoResult addContentCategory(Long parentId,String categoryName);

    void updateContentCategory(Long id,String name);

    void deleteContentCategory(Long id);
}
