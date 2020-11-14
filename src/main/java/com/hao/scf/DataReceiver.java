package com.hao.scf;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;

/**
 * <code>DataReceiver</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2020-07-30
 * @version: 1.0
 */
public class DataReceiver {

    private DataReceiver(){
        System.out.println("执行构造方法。。。");
    }

    private final static class DataReceiverHolder {
        private final static DataReceiver instance = new DataReceiver();
    }

    public static DataReceiver instance(){
        return DataReceiverHolder.instance;
    }

}
