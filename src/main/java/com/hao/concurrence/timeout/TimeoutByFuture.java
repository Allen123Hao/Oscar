package com.hao.concurrence.timeout;

import com.hao.httpclient.Demo1;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * <code>TimeoutByFuture</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/6/21
 * @version: 1.0
 */
public class TimeoutByFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/upload");
//        RequestConfig config = RequestConfig.custom()
//                .setConnectTimeout(5000)
//                .setSocketTimeout(5000)
//                .setConnectionRequestTimeout(5000)
//                .build();
//        httpPost.setConfig(config);
        File file = new File("/Users/haoxueqiang/Downloads/mac.txt");
        FileBody bin = new FileBody(file);
        HttpEntity httpEntity = MultipartEntityBuilder.create().addPart("file",bin).build();
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response = null;

        MyTask myTask = new MyTask(20,httpClient,httpPost);
        Future<CloseableHttpResponse> future = service.submit(myTask);

        try {
//            int result = (int) future.get(5000,TimeUnit.MILLISECONDS);
//            System.out.println("result:"+result);
            response = future.get(5,TimeUnit.SECONDS);

            System.out.println("==========");
            System.out.println(response.getStatusLine());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e){
            e.printStackTrace();
        }finally {
            httpPost.abort();

        }
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        System.out.println(service.isTerminated());

        if(response == null){
            System.out.println("第二次上传start");
            MyTask myTask1 = new MyTask(5,httpClient,httpPost);
            future = service.submit(myTask1);
            try {
                response = future.get(5,TimeUnit.SECONDS);
            } catch (TimeoutException e) {
                System.out.println("第二次abort");
                httpPost.abort();
            }
            System.out.println("第二次上传end");
        }
//        MyTask myTask1 = new MyTask(5);
//        service.submit(myTask1);
//        List<Runnable> list = service.shutdownNow();
//        System.out.println(list);
        service.shutdown();


    }

}

class MyTask implements Callable<CloseableHttpResponse>{

    private int time;
    private int result;
    private CloseableHttpClient httpClient;
    private HttpPost httpPost;

    public MyTask(int time,CloseableHttpClient httpClient,HttpPost httpPost){
        this.time = time;
        this.httpClient = httpClient;
        this.httpPost = httpPost;

    }
    public int getResult() {
        return result;
    }



    @Override
    public CloseableHttpResponse call() throws Exception {

        int count = 0;
//        while(count < time){
//            System.out.println(count);
//            try {
//
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                throw e;
//            }
//            count++;
//            result++;
//        }
        CloseableHttpResponse response = null;
        try{
            System.out.println("执行call");
            Thread.sleep(1000);
            response = httpClient.execute(httpPost);
            System.out.println("==========");
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            response.close();
        }catch (InterruptedException e){
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}
