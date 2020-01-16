package com.hao.concurrence.demo;

public class DeadLock {
	static class Friend{
		private String name;
		public Friend(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		
		public synchronized void bow(Friend bower){
			System.out.format("%s:%s" + " has bowed to me!%n", 
					this.name,bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack(Friend bower){
			System.out.format("%s: %s"  + " has bowed back to me!%n",
					this.name, bower.getName()); 
		}
	}
	public static void main(String[] args){
		final Friend alphose = new Friend("alphose");
		final Friend gaston = new Friend("gaston");
		new Thread(new Runnable(){
			@Override
			public void run() {
				alphose.bow(gaston);
			}
			
		}).start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				gaston.bow(alphose);
			}
			
		}).start();
	}
}
