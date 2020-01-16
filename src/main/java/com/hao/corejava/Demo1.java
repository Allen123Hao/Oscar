package com.hao.corejava;

import java.util.HashMap;
import java.util.Map;

/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/11
 * @version: 1.0
 */
public class Demo1 {
    private static final Demo1 instance = new Demo1();
    private Map<String,String> config = new HashMap<String,String>();
    private Demo1(){
        System.out.println("This is Demo1 default Constructor");
        config.put("key1", "value1");
        config.put("key2", "value2");
        config.put("key3","value3");
        config.put(Demo3.HDFSConfigKey.FS_HDFS_IMPL,Demo3.HDFSConfig.getFsHdfsImpl());
    }
    static {
        System.out.println("This is static block.");
    }
    public static Demo1 getInstance(){
        return instance;
    }
    public static void fun1(){
        System.out.println("This is fun1 of Demo1.");
    }
    public String getConfigByKey(String key){
        return config.get(key);
    }
}
