package com.hao.designpattern.prototype;

public class OrderClient {

	public static void main(String[] args) {
		PersonalOrder order1 = new PersonalOrder();
		order1.setCustomerName("王小明");
		order1.setProductId("P0001");
		order1.setOrderProductNum(3569);
		EnterpriseOrder order2 = new EnterpriseOrder();
		order2.setEnterpriseName("阿里巴巴");
		order2.setProductId("P0002");
		order2.setOrderProductNum(6543);
		OrderBusiness business = new OrderBusiness();
		business.saveOrder(order1);
		business.saveOrder(order2);
	}
}
