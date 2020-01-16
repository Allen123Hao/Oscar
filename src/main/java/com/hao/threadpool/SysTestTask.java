package com.hao.threadpool;  
/**
 * Project Name:ThreadTest
 * File Name:SysTestTask.java
 * Package Name:
 * Date:2015年1月12日下午3:35:21
 * Copyright (c) 2015, jujiasoft All Rights Reserved.
 *
 */

/**
 * ClassName:SysTestTask <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年1月12日 下午3:35:21 <br/>
 * @author   RD
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class SysTestTask extends Task{

	@Override
	public void run() {
		System.out.println("开始");
	try {
		this.taskCore();
	} catch (Exception e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	System.out.println("结束");
	}

	@Override
	public Task[] taskCore() throws Exception {
		System.out.println("woshishui");
		System.out.println(Thread.currentThread().getName()+"-----"+Thread.currentThread().activeCount());
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean useDb() {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean needExecuteImmediate() {
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String info() {
		
		// TODO Auto-generated method stub
		return "Systest   执行了！！！！";
	}

}

