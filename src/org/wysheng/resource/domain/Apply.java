package org.wysheng.resource.domain;

import java.util.Date;

/**
 * 
  ApplyID            NUMBER(6)            not null,--申请单ID
   ApplyTypeID        NUMBER(8)              not null,--申请单类型ID
   ApplyDate          DATE,--申请日期
   ApplyStatus        NUMBER(8),--申请单状态
   UserID             CHAR(12),--申请人ID
   Approver           CHAR(12),--审批人ID
   Assigner           CHAR(12),--分配人ID
   Dealer             CHAR(12),--处理人ID
   Phone              VARCHAR2(50),--申请单主题
   ApplyTitle         VARCHAR2(50),--申请原因
   ApplyReason        VARCHAR2(200),--联系电话
   Enclosure          VARCHAR2(200),--备注
   Remark             VARCHAR2(500),--附件
 * 
 * 
 * 
 * */
//申请单
public class Apply {
    //申请单ID
	private Integer applyID;
	//申请单类型ID
	private ApplyFlow applyTypeID;
	//申请日期
	private Date applyDate;
	//申请单状态
	private Integer applyStatus;
	//申请人
	private String userID;
	//审批人
	private String approver;
	//分配人
	private String assigner;
	//处理人
	private String dealer;
	//申请单主题
	private  String phone;
	//申请原因
	private  String applyTitle;
	//联系电话
	private String applyReason;
	//备注
	private String enclosure;
	//附件
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
