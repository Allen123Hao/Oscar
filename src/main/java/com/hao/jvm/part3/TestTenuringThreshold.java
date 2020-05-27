package com.hao.jvm.part3;

/**
 * <code>TestTenuringThreshold</code>
 *
 * @description: 长期存活的对象进入老年代
 * java启动参数：-Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 * -verbose:gc -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+UseSerialGC
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-04-29
 * @version: 1.0
 */
public class TestTenuringThreshold {

    private static final int _1MB = 1024*1024*10;

    private static void testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB/4];
        allocation2 = new byte[4*_1MB];
        allocation3 = new byte[4*_1MB];
        allocation3 = null;
        allocation3 = new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
