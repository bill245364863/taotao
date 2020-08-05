/**
 * 公司：顶点信息
 * 文件名:TestFastDFS
 * 作者:bill
 * 时间：2020/5/10 11:52
 * 描述：
 */
package com.taotao.fastdfs;

import com.taotao.util.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.net.URLEncoder;


public class TestFastDFS { 
    @Test
  public  void uploadFile() throws Exception{
      //1.向工程中添加jar包
      //2.创建一个配置文件，配置tracker服务器的地址

      //3.加载这个配置文件
      ClientGlobal.init("E:/ideaWorkSpaces/taotao/taotaomanageweb/src/main/resources/resource/client.conf");
      //4.创建trackerCient对象
        TrackerClient trackerClient = new TrackerClient();
      //5。使用trackerClient对象获得trackerServer对象
        TrackerServer trackerServer = trackerClient.getTrackerServer();
      //6.创建一个StorageServer的引用null就可以
        StorageServer storageServer = null;
      //7.创建StorageClient对象，trackerserver、storageserver两个参数
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
      //8.使用storageclient对象上传文件
        String[] jpgs = storageClient.upload_file("E:/MyDocument/我的文件/学习文件/【阶段17】淘淘商城综合项目/参考资料/广告图片/1.jpg", "jpg", null);
        for (String jpg : jpgs){
            System.out.println(jpg);
        }
    }

    @Test
    public  void  testFastDFSClient() throws  Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("E:/ideaWorkSpaces/taotao/taotaomanageweb/src/main/resources/resource/client.conf");
        String s = fastDFSClient.uploadFile("E:/MyDocument/我的文件/学习文件/【阶段17】淘淘商城综合项目/参考资料/广告图片/2.jpg");
        System.out.println(s);
    }
    @Test
    public void testUrlEncode() throws Exception{
        String string = "http://121.204.33.35:9888/BPMServlet?_SERVLET_TOKEN_=DingLoginServlet&appCode=ceshi&action=login&redirect=L3BsdWdpbi91cmlTZXJ2aWNlLmRvP3E9WWdBV0NqeSpGdURVbTFGVkc2am9GSkY0MnFiRFUtNVphMC00czB1aUxLQmN3cUFQdDRTa01iLWNwTSpJUSpYaHFPYlh4MmpaNy1wUGhRaHBFNHV3VzkycFRTUk01N096a2F6WE9oakFna0RiajhsbTk3T2dhZjJ5dlFtaGkzMHc.";
        String strEncode = URLEncoder.encode(string, "utf-8");
        System.out.println(strEncode);

    }

}
