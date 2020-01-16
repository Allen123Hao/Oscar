package com.hao.concurrence.threadlocal;

import java.util.HashMap;

public class ThreadLocalTest {

	static ThreadLocal<HashMap<Integer,Integer>> map0 = new ThreadLocal<HashMap<Integer,Integer>>(){
		@Override
		protected HashMap<Integer,Integer> initialValue() {
			System.out.println(Thread.currentThread().getName()+"initialValue");
			return new HashMap<Integer,Integer>();
		}
	};
	public void run(){
		Thread[] threads = new Thread[3];
		for(int i=0;i<3;i++){
			threads[i] = new Thread(new Thread1(i),"线程"+i);
		}
		for(Thread t : threads){
			t.start();
		}
	}
	public static class Thread1 implements Runnable{
		int id;
		public Thread1(int id) {
			this.id = id;
			System.out.println("This id:"+this.id);
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+":start");
			HashMap<Integer, Integer> map = map0.get();
			for(int i=0;i<10;i++){
				map.put(i, i+id*100);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+map);
		}
	}
	
	public static void main(String[] args) {
		ThreadLocalTest test = new ThreadLocalTest();
		test.run();
	}
	
}
