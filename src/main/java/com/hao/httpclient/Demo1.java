package com.hao.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharsetUtils;
import org.apache.http.util.EntityUtils;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * <code>Demo1</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/8
 * @version: 1.0
 */
public class Demo1 {

    public static void doGet(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/test");
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
        httpGet.setConfig(config);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doPost(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/test");
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
        httpPost.setConfig(config);
        httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
        try {
//            List<NameValuePair> list = new ArrayList<>();
//            list.add(new BasicNameValuePair("name","xueqiang.hao"));
//            HttpEntity httpEntity = new UrlEncodedFormEntity(list,"UTF-8");
            HttpEntity httpEntity = new StringEntity("{'name':'xueqiang.hao'}","UTF-8");
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println("==========");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            response.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //post上传文件
    public static Object doPostFiles(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/upload");
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(5000)
//                .setSocketTimeout(5000)
//                .setConnectionRequestTimeout(5000)
//                .build();
//        httpPost.setConfig(config);
        try {
            File file = new File("/Users/haoxueqiang/Downloads/mac.txt");
            FileBody bin = new FileBody(file);
            HttpEntity httpEntity = MultipartEntityBuilder.create().addPart("file",bin).build();
            httpPost.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);

            System.out.println("==========");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            response.close();
            return response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }


    public static void doPut(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("http://localhost:8080/test");
        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
//                .setConnectionRequestTimeout(5000)
                .build();
        httpPut.setConfig(config);
        httpPut.setHeader(HTTP.CONTENT_TYPE, "application/json");
        try {
//            List<NameValuePair> list = new ArrayList<>();
//            list.add(new BasicNameValuePair("name","xueqiang.hao"));
//            HttpEntity httpEntity = new UrlEncodedFormEntity(list,"UTF-8");
            HttpEntity httpEntity = new StringEntity("{'name':'xueqiang.hao'}","UTF-8");
            httpPut.setEntity(httpEntity);
            CloseableHttpResponse response = httpClient.execute(httpPut);
            System.out.println("==========");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            response.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void doPostForm(){
        UrlEncodedFormEntity entity = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            List<NameValuePair> form = new ArrayList<>();
            form.add(new BasicNameValuePair("foo", "bar"));
            form.add(new BasicNameValuePair("employee", "maxsu"));
            entity = new UrlEncodedFormEntity(form, "UTF-8");

            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            httpPost.setEntity(entity);
            System.out.println("Executing request " + httpPost.getRequestLine());
            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity responseEntity = response.getEntity();
                    return responseEntity != null ? EntityUtils.toString(responseEntity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpClient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    private static void test(){
        int a = 0;
        try {
            while(true){
                System.out.println(a);
                try {
                    a++;
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(a==5){
                        break;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Demo1.test();
    }
}
