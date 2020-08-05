/**
 * 公司：顶点信息
 * 文件名:EasyUIDataGridResult
 * 作者:bill
 * 时间：2020/3/22 19:27
 * 描述：
 */
package com.taotao.common;

import java.io.Serializable;
import java.util.List;

public class EasyUIDataGridResult implements Serializable {
    private  long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
