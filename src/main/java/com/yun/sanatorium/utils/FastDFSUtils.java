package com.yun.sanatorium.utils;

public class FastDFSUtils {
    //读取resource下fastDfs配置文件
  public static final String FILE_SERVICE_URL = Thread.currentThread().getContextClassLoader().getResource("fdfs_client.properties").getPath();
    //文件保存路径前部份
  public static final   String PATH = "http://39.100.70.223/";
}
