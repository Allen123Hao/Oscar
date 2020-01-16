package com.hao.designpattern.observer;

public class Observer implements SubjectNotice{
	private String name;

	private String message;

	public Observer(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println(name+"已获得通知，内容为："+message);
	}

	@Override
	public void noticeMessage(Subject subject) {
		setMessage(subject.getMessage());
		System.out.println(getName()+"已经阅读了"+subject.getName()+"提供的内容！");
	}
	
	
}
