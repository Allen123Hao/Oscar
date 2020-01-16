package com.hao.designpattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
	
	private String name;
	
	private String message;
	
	List<Observer> observers = new ArrayList<Observer>();
	
	public Subject(String name){
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
		if(observers.size()==0){
			return;
		}
		for(Observer observer : observers){
			String name = observer.getName();
			System.out.println("��ʼ֪ͨ"+name+"����");
			observer.noticeMessage(this);
			System.out.println(name+"��֪ͨ��������");
		}
	}
	
	void registerOberver(Observer observer){
		observers.add(observer);
	}
	
}
