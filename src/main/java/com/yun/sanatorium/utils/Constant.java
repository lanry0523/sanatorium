package com.yun.sanatorium.utils;

public class Constant {
    //读取resource下fastDfs配置文件
  public static final String FILE_SERVICE_URL = Thread.currentThread().getContextClassLoader().getResource("fdfs_client.properties").getPath();
    //文件保存路径前部份
  public static final   String PATH = "http://39.100.70.223/";

  //小程序 wxab642be6f7f72aad  170246997160833863684e99dfdb6c0b     wx842ca39dee694a27    1d4327c2e145b646de5049f75c892593
  public static final String APP_ID = "wxab642be6f7f72aad";
  public static final String APP_SECRET = "170246997160833863684e99dfdb6c0b";

}
