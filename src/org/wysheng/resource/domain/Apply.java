package org.wysheng.resource.domain;

import java.util.Date;

/**
 * 
  ApplyID            NUMBER(6)            not null,--���뵥ID
   ApplyTypeID        NUMBER(8)              not null,--���뵥����ID
   ApplyDate          DATE,--��������
   ApplyStatus        NUMBER(8),--���뵥״̬
   UserID             CHAR(12),--������ID
   Approver           CHAR(12),--������ID
   Assigner           CHAR(12),--������ID
   Dealer             CHAR(12),--������ID
   Phone              VARCHAR2(50),--���뵥����
   ApplyTitle         VARCHAR2(50),--����ԭ��
   ApplyReason        VARCHAR2(200),--��ϵ�绰
   Enclosure          VARCHAR2(200),--��ע
   Remark             VARCHAR2(500),--����
 * 
 * 
 * 
 * */
//���뵥
public class Apply {
    //���뵥ID
	private Integer applyID;
	//���뵥����ID
	private ApplyFlow applyTypeID;
	//��������
	private Date applyDate;
	//���뵥״̬
	private Integer applyStatus;
	//������
	private String userID;
	//������
	private String approver;
	//������
	private String assigner;
	//������
	private String dealer;
	//���뵥����
	private  String phone;
	//����ԭ��
	private  String applyTitle;
	//��ϵ�绰
	private String applyReason;
	//��ע
	private String enclosure;
	//����
	private String remark;
	public Integer getApplyID() {
		return applyID;
	}
	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}
	public ApplyFlow getApplyTypeID() {
		return applyTypeID;
	}
	public void setApplyTypeID(ApplyFlow applyTypeID) {
		this.applyTypeID = applyTypeID;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getAssigner() {
		return assigner;
	}
	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}
	public String getDealer() {
		return dealer;
	}
	public void setDealer(String dealer) {
		this.dealer = dealer;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getApplyTitle() {
		return applyTitle;
	}
	public void setApplyTitle(String applyTitle) {
		this.applyTitle = applyTitle;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getEnclosure() {
		return enclosure;
	}
	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
} 
