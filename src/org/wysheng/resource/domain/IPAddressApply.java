package org.wysheng.resource.domain;

import java.util.Date;

/****
 * ApplyID            NUMBER(8)              not null,--申请单ID
   Quantity           NUMBER(8),--申请数量
   Address            VARCHAR2(50),--使用地点
   PortNumber         VARCHAR2(50),--网口号码
   TimeLimit          DATE,--使用时间
   constraint PK_IPADDRESSAPPLY primary key (ApplyID)--申请单ID主鍵
 * 
 * 
 * 
 * */
//IPAddressApply（IP地址申请单）
public class IPAddressApply {
	//申请单ID
	private Integer applyID;
	//申请数量
	private Integer quantity;
	//使用地点
	private String address;
	//网口号码
	private String portNumber;
	//使用时间
	private Date timeLimit;

	
	public Integer getApplyID() {
		return applyID;
	}
	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(String portNumber) {
		this.portNumber = portNumber;
	}
	public Date getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Date timeLimit) {
		this.timeLimit = timeLimit;
	}

}
