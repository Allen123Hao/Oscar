package com.hao.designpattern.prototype;

public class OrderBusiness {
	public void saveOrder(OrderApi order){
		while(order.getOrderProductNum() > 1000){
			OrderApi newOrder = order.cloneOrder();
			newOrder.setOrderProductNum(1000);
			order.setOrderProductNum(order.getOrderProductNum()-1000);
			System.out.println("拆分生成的订单是："+newOrder.toString());
		}
		System.out.println("订单："+order.toString());
	}
}
