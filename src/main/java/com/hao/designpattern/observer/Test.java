package com.hao.designpattern.observer;

public class Test {
	public static void main(String[] args){
		final Subject subject = new Subject("河北报社");
		final Observer observer1 = new Observer("observer1");
		subject.registerOberver(observer1);
		final Observer observer2 = new Observer("observer2");
		subject.registerOberver(observer2);

		subject.setMessage("今天晚上有雷阵雨！");
	}
}
