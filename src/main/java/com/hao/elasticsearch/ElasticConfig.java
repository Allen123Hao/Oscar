package com.hao.elasticsearch;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <code>ElasticConfig</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/28
 * @version: 1.0
 */
public class ElasticConfig {

    protected static TransportClient initClient1(){

        TransportAddress master;
        TransportAddress slave1;
        TransportAddress slave2;

        try {
            master = new InetSocketTransportAddress(
                    InetAddress.getByName("127.0.0.1"),
                    9300
            );
            slave1 = new InetSocketTransportAddress(
                    InetAddress.getByName("127.0.0.1"),
                    9301
            );
            slave2 = new InetSocketTransportAddress(
                    InetAddress.getByName("127.0.0.1"),
                    9302
            );

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
        Settings settings = Settings.builder()
                .put("cluster.name","allen")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddresses(master,slave1,slave2);
        return client;
    }

    protected static TransportClient initClient2(){

        TransportAddress master;
        TransportAddress slave1;
        TransportAddress slave2;
        TransportAddress slave3;
        TransportAddress slave4;


        try {
            master = new InetSocketTransportAddress(
                    InetAddress.getByName("172.20.42.1"),
                    9300
            );
            slave1 = new InetSocketTransportAddress(
                    InetAddress.getByName("172.20.42.1"),
                    9301
            );
            slave2 = new InetSocketTransportAddress(
                    InetAddress.getByName("172.20.42.1"),
                    9302
            );
            slave3 = new InetSocketTransportAddress(
                    InetAddress.getByName("172.20.42.2"),
                    9300
            );
            slave4 = new InetSocketTransportAddress(
                    InetAddress.getByName("172.20.42.2"),
                    9301
            );

        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
        Settings settings = Settings.builder()
                .put("cluster.name","mcasset")
                .build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddresses(master,slave1,slave2,slave3,slave4);
        return client;
    }
}
