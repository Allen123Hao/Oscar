package com.hao.concurrence.interrupt;

/**
 * 演示对非阻塞中的线程中断
 * @author AllenHao
 *
 */
public class InterruptTest {

	public static void main(String[] args) {
		int flag = 1;
		Thread1 t = new Thread1();
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("main interrupt");
			e.printStackTrace();
		}
		t.interrupt();
		System.out.println("Continue...");
	}

}
class Thread1 extends Thread{
	int count = 0;
	Object obj = new Object();

	@Override
	public void run() {
		while(true){
			System.out.println(count++);
			if(Thread.interrupted()){
				System.out.println("Someone interrupt me");
			}else{
				System.out.println("Going...");
			}
//			long now = System.currentTimeMillis();
//			while((System.currentTimeMillis()-now)<1000){
//				
//			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread1 interrupt");
				e.printStackTrace();
			}
		}
	}
	
}
