package com.hao.druid;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <code>TransformFiles</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/5/15
 * @version: 1.0
 */
public class TransformFiles {
    private String func1(String date){
//        String date = "2015-09-12T01:16:54.390Z";

        String date1 = date.replace("T"," ").replace("-","/").replaceAll("\\.[\\d]{3}Z","");
//        System.out.println(date1);
        return date1;

    }

    private void func2(){
        try {
            URL url = new URL("http","172.20.42.2",7001,"wikiticker-2015-09-12-sampled2.csv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(100000);
            connection.setConnectTimeout(100000);
            connection.connect();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                System.out.println("请求失败……");
                return;
            }

            Map<String,List<String>> headers = connection.getHeaderFields();
            Iterator<Map.Entry<String,List<String>>> iterator = headers.entrySet().iterator();
            System.out.println("header info:");
            while(iterator.hasNext()){
                Map.Entry<String,List<String>> entry = iterator.next();
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
            System.out.println("响应内容如下：");
            File tempFile = new File("/Users/haoxueqiang/Downloads/temp.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String data = null;
            while((data = reader.readLine()) != null){
                int index = data.indexOf(",");
                String date = data.substring(0,index);
                String newDate = func1(date);
                String newLine = newDate+data.substring(index,data.length());
                writer.write(newLine+"\n");
            }
            System.out.println("last line:"+data);
            writer.flush();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        TransformFiles app = new TransformFiles();
        app.func2();
    }
}
