/**
 * Project Name:ThreadTest
 * File Name:Test.java
 * Package Name:bb
 * Date:2015年1月12日下午4:21:51
 * Copyright (c) 2015, jujiasoft All Rights Reserved.
 *
*/

package com.hao.threadpool;  
/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年1月12日 下午4:21:51 <br/>
 * @author   RD
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

//测试线程池  
public class TestThreadPool {  
  public static void main(String[] args) {  
      // 创建3个线程的线程池  
      ThreadPool t = ThreadPool.getThreadPool(3);  
      t.execute(new Runnable[] { new Task(), new Task(), new Task() });  
      t.execute(new Runnable[] { new Task(), new Task(), new Task() });  
      System.out.println(t);  
      t.destroy();// 所有线程都执行完成才destory  
      System.out.println(t);  
  }  

  // 任务类  
  static class Task implements Runnable {  
      private static volatile int i = 1;  

      @Override  
      public void run() {// 执行任务  
          System.out.println("任务 " + (i++) + " 完成");  
      }  
  }  
}  


