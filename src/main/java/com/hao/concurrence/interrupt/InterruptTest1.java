package com.hao.concurrence.interrupt;

/**
 * 程序演示的是子线程通知父线程别等它了
 * @author AllenHao
 *
 */
public class InterruptTest1 {

	public static void main(String[] args) {
		Thread2 thread2 = new Thread2(Thread.currentThread());
		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Parent thread will die");
		}
		System.out.println("Parent thread end");
	}

}
class Thread2 extends Thread{
	private Thread parent;
	public Thread2(Thread thread){
		this.parent = thread;
	}
	public void run(){
		while(true){
			System.out.println("sub thread is running");
//			long now = System.currentTimeMillis();
//			while((System.currentTimeMillis() - now) < 2000){
//				
//			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("sub thread interrupt exception");
				e.printStackTrace();
			}
			parent.interrupt();
		}
		
	}
}
