package com.hao.threadpool;  

/**
 * Project Name:ThreadTest
 * File Name:Test.java
 * Package Name:
 * Date:2015年1月12日下午3:37:06
 * Copyright (c) 2015, jujiasoft All Rights Reserved.
 *
 */

/**
 * ClassName:Test <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年1月12日 下午3:37:06 <br/>
 * @author   RD
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class Test {
	
public static void main(String[] args) {
	//ThreadPool th=ThreadPool.getInstance();
	 ThreadPool t = ThreadPool.getThreadPool(9);  
	for(int i=0;i<1000;i++){
	
	t.execute(new SysTestTask());
	}
}
}

