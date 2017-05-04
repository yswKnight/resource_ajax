package org.wysheng.resource.domain;

import java.util.Date;

/***
 * ApplyID            NUMBER(8)              not null,--申请单ID
   Zone               NUMBER(8),--空间
   InterfaceMan       VARCHAR2(50),--接口人
   Right              VARCHAR2(50),--权限
   TimeLimit          DATE,--使用期限
   constraint PK_STORAGESPACEAPPLY primary key (ApplyID)--申请单ID主鍵
 * 
 * 
 * 
 * 
 * **/
public class StorageSpaceApply {
	//申请单ID
	private Integer applyID;
	//空间
	private Integer zone;
	//接口人
	private  String  interfaceMan;
	//权限
	private String right;
	//使用期限
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
