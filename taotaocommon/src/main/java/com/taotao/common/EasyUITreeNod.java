/**
 * 公司：顶点信息
 * 文件名:EasyUITreeNod
 * 作者:bill
 * 时间：2020/3/28 19:23
 * 描述：
 */
package com.taotao.common;

import java.io.Serializable;

/*因为是服务端响应过来的，所以需要实现序列化接口*/
public class EasyUITreeNod implements Serializable {
    /*类目id*/
    private  long id;
    /*类名*/
    private  String text;
    /*是否有子节点，如果有子节点就是close，如果没有子节点就是open*/
    private  String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
