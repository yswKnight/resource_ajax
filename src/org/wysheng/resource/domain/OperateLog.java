package org.wysheng.resource.domain;

import java.util.Date;

/****
 * ID                   NUMBER(6)            not null,--������¼ID
   ApplyID            NUMBER(8)              not null,--���뵥ID
   OperateType        VARCHAR2(20),--��������
   OperateDate        DATE,--��������
   UserID             CHAR(12),--������
   Describe           VARCHAR2(100),--����˵��
   Result             VARCHAR2(20),--�������
   constraint PK_OPERATELOG primary key (ID)--������¼ID���I
 * 
 * 
 * 
 * */
//OperateLog�����뵥���̲�����¼��
public class OperateLog {
	//������¼ID
	private Integer id;
	//���뵥ID
	private Apply applyID;
	//��������
	private String operateType;
	//��������
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
	//������
	private String  userID;
	//����˵��
	private String describe;
	//�������
	private String result;
	
	

}
