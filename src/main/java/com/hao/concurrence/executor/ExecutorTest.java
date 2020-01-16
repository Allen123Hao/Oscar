package com.hao.concurrence.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
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

}
