package com.hao.corejava;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <code>Demo3</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/11/11
 * @version: 1.0
 */
public class Demo3 {
    private static Properties pro = new Properties();

    public static final class HDFSConfigKey {
        public static final String FS_HDFS_IMPL = "fs.hdfs.impl";
    }
    public static class HDFSConfig {
        private static String FS_HDFS_IMPL;

        public static String getFsHdfsImpl() {
            return FS_HDFS_IMPL;
        }
    }
    static {
        InputStream is = new BufferedInputStream(Demo3.class.getResourceAsStream("/system.property"));
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HDFSConfig.FS_HDFS_IMPL = pro.getProperty("FS_HDFS_IMPL");
        System.out.println("HDFSConfig.FS_HDFS_IMPL:"+HDFSConfig.FS_HDFS_IMPL);
    }
}
