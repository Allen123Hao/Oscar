package com.hao.scf;

/**
 * <code>AppTest</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-30
 * @version: 1.0
 */
public class AppTest {

    private DataReceiver dataReceiver = null;

    public static void main(String[] args) {
        AppTest appTest1 = new AppTest();
        appTest1.dataReceiver = DataReceiver.instance();
        AppTest appTest2 = new AppTest();
        appTest2.dataReceiver = DataReceiver.instance();
    }
}
