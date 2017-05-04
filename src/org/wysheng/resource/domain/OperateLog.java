package org.wysheng.resource.domain;

import java.util.Date;

/****
 * ID                   NUMBER(6)            not null,--操作记录ID
   ApplyID            NUMBER(8)              not null,--申请单ID
   OperateType        VARCHAR2(20),--操作类型
   OperateDate        DATE,--操作日期
   UserID             CHAR(12),--操作人
   Describe           VARCHAR2(100),--操作说明
   Result             VARCHAR2(20),--操作结果
   constraint PK_OPERATELOG primary key (ID)--操作记录ID主鍵
 * 
 * 
 * 
 * */
//OperateLog（申请单流程操作记录表）
public class OperateLog {
	//操作记录ID
	private Integer id;
	//申请单ID
	private Apply applyID;
	//操作类型
	private String operateType;
	//操作日期
	private Date operateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Apply getApplyID() {
		return applyID;
	}
	public void setApplyID(Apply applyID) {
		this.applyID = applyID;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	//操作人
	private String  userID;
	//操作说明
	private String describe;
	//操作结果
	private String result;
	
	

}
