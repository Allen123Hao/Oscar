package com.hao.elasticsearch;

import com.google.gson.Gson;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * <code>ElasticDemo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/4/28
 * @version: 1.0
 */
public class ElasticDemo1 {

    public void getById(String id){
        TransportClient client = ElasticConfig.initClient1();
        GetResponse response = client.prepareGet().
                setIndex("book")
                .setType("novel")
                .setId(id)
                .get();
        Map<String,Object> map = response.getSource();
        System.out.println("response:" + new Gson().toJson(map));
    }



    public static void main(String[] args) {
        ElasticDemo1 demo1 = new ElasticDemo1();
        demo1.getById("1");
    }



}
