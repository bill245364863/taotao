/**
 * 公司：顶点信息
 * 文件名:PictureController
 * 作者:bill
 * 时间：2020/5/10 19:05
 * 描述：
 */
package com.manage.controller;

import com.taotao.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/* *
 * @Author bill
 * @email 245364863@qq.com
 * @Description //TODO  图片上传
 * @Date 19:05 2020/5/10
 * @Param
 * @return
 **/
@Controller
public class PictureController {
    @Value("${IMAGE_SERVER_URL}")
    private  String IMAGE_SERVER_URL;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map picUpload(MultipartFile uploadFile){
        try {
            //接收上传的文件
            //取扩展名
            String originalFilename = uploadFile.getOriginalFilename();//文件全名
            String extName =  originalFilename.substring(originalFilename.lastIndexOf(".")+1);//取扩展
            //上传到服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            url = IMAGE_SERVER_URL + url;
            //响应上传图片的url
            Map result = new HashMap();
            result.put("error", 0);
            result.put("url", url);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap();
            result.put("error", 1);
            result.put("message", "图片上传失败！");
            return result;
        }

    }
}
