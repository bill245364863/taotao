/**
 * 公司：顶点信息
 * 文件名:LayuiParseDataResult
 * 作者:bill
 * 时间：2020/3/31 23:18
 * 描述：
 */
package com.taotao.common;

import java.io.Serializable;
import java.util.List;

public class LayuiParseDataResult implements Serializable {
    /*接口状态*/
    private int code;
    /*提示文本*/
    private String msg;
    /*数据长度*/
    private int count;
    /*数据列表*/
    private List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
