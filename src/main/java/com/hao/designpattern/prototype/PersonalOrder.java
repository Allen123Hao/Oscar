package com.hao.designpattern.prototype;

public class PersonalOrder implements OrderApi {
	
	private String customerName;
	
	private String productId;
	
	private int orderProductNum = 0;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getOrderProductNum() {
		return orderProductNum;
	}
	public void setOrderProductNum(int orderProductNum) {
		this.orderProductNum = orderProductNum;
	}



	@Override
	public String toString() {
		return "本个人订单的订购人是："+this.getCustomerName()+"，"
				+ "订购产品是："+this.getProductId()+"，"
				+ "订购数量是："+this.getOrderProductNum();
	}
	@Override
	public OrderApi cloneOrder() {
		PersonalOrder personalOrder = new PersonalOrder();
		personalOrder.setCustomerName(this.customerName);
		personalOrder.setProductId(this.productId);
		personalOrder.setOrderProductNum(this.orderProductNum);
		return personalOrder;
	}

}
