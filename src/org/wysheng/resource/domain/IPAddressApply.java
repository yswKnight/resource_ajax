package org.wysheng.resource.domain;

import java.util.Date;

/****
 * ApplyID            NUMBER(8)              not null,--���뵥ID
   Quantity           NUMBER(8),--��������
   Address            VARCHAR2(50),--ʹ�õص�
   PortNumber         VARCHAR2(50),--���ں���
   TimeLimit          DATE,--ʹ��ʱ��
   constraint PK_IPADDRESSAPPLY primary key (ApplyID)--���뵥ID���I
 * 
 * 
 * 
 * */
//IPAddressApply��IP��ַ���뵥��
public class IPAddressApply {
	//���뵥ID
	private Integer applyID;
	//��������
	private Integer quantity;
	//ʹ�õص�
	private String address;
	//���ں���
	private String portNumber;
	//ʹ��ʱ��
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
