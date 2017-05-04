package org.wysheng.resource.domain;

import java.util.Date;

/***
 * ApplyID            NUMBER(8)              not null,--���뵥ID
   Zone               NUMBER(8),--�ռ�
   InterfaceMan       VARCHAR2(50),--�ӿ���
   Right              VARCHAR2(50),--Ȩ��
   TimeLimit          DATE,--ʹ������
   constraint PK_STORAGESPACEAPPLY primary key (ApplyID)--���뵥ID���I
 * 
 * 
 * 
 * 
 * **/
public class StorageSpaceApply {
	//���뵥ID
	private Integer applyID;
	//�ռ�
	private Integer zone;
	//�ӿ���
	private  String  interfaceMan;
	//Ȩ��
	private String right;
	//ʹ������
	private Date timeLimit;

	
	public Integer getApplyID() {
		return applyID;
	}
	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}
	public Integer getZone() {
		return zone;
	}
	public void setZone(Integer zone) {
		this.zone = zone;
	}
	public String getInterfaceMan() {
		return interfaceMan;
	}
	public void setInterfaceMan(String interfaceMan) {
		this.interfaceMan = interfaceMan;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	public Date getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Date timeLimit) {
		this.timeLimit = timeLimit;
	}
	

}
