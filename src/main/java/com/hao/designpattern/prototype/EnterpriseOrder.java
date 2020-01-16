package com.hao.designpattern.prototype;

public class EnterpriseOrder implements OrderApi {
	
	private String enterpriseName;
	private String productId;
	private int orderProductNum = 0;

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
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

	public String toString() {
		return "本企业订单的订购企业是："+this.getEnterpriseName()+"，"
				+ "订购产品是："+this.getProductId()+"，"
				+ "订购数量是："+this.getOrderProductNum();
	}

	@Override
	public OrderApi cloneOrder() {
		EnterpriseOrder enterpriseOrder = new EnterpriseOrder();
		enterpriseOrder.setEnterpriseName(this.enterpriseName);
		enterpriseOrder.setProductId(this.productId);
		enterpriseOrder.setOrderProductNum(this.orderProductNum);
		return enterpriseOrder;
	}

}
