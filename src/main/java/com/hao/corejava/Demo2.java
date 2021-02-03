package com.hao.corejava;

/**
 * <code>Demo2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/11
 * @version: 1.0
 */
public class Demo2 {
//    private Solution_70 demo1;
    private static Demo1 demo1 = Demo1.getInstance();
    public Demo2(){
        System.out.println("This is Demo2 default Constructor.");
    }

    static {
        initFileSystem();
    }
    private static void initFileSystem(){
        System.out.println("====initFileSystem====");
//        String str =  demo1.getConfigByKey("fs.hdfs.impl");
        String str = demo1.getConfigByKey(Demo3.HDFSConfigKey.FS_HDFS_IMPL);
        System.out.println("fs.hdfs.impl:"+str);
    }

    public void printConfig(String key){
        String value = demo1.getConfigByKey(key);
        System.out.println(key+":"+value);
    }
    public void initFun(){
        String value = demo1.getConfigByKey("key3");
        System.out.println("key3:"+value);
    }
//    public static void main(String[] args){
//        Demo2 demo2 = new Demo2();
//        demo2.printConfig("key1");
//
//    }
}
