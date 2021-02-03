package com.hao.concurrence.executor;

import java.util.concurrent.*;

public class ExecutorTest {

	public void test1(){
		ExecutorService loadA = Executors.newFixedThreadPool(7);
		try {
			String output = loadA.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					String s = "I am a task,while submited by so called loadA,and run"
							+ "by those anonymous works";
					Thread.sleep(10000);
					return s;
				}
			}).get();
			System.out.println("abc");
			System.out.println(output);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void test2(){
		Runnable r = ()->{
			System.out.println("开始");
			for(int i=1;i<=5;i++){
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//		service.schedule(()-> System.out.println("hello"),2,TimeUnit.SECONDS);
//		service.scheduleAtFixedRate(r,3,3,TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(r,3,3,TimeUnit.SECONDS);
//		service.shutdown();
	}

	public static void main(String[] args) {
		ExecutorTest test = new ExecutorTest();
		test.test2();
	}

}
