package org.wysheng.resource.domain;
/*
 * ApplyTypeID        NUMBER(6)            not null,--申请单类型ID
ApplyTypeName      VARCHAR2(50),--申请单类型名称
Assigner           CHAR(12),--分配人ID
constraint PK_APPLYFLOW primary key (ApplyTypeID)--申请单类型ID主鍵
 * 
 * 
 * 
 * */
//ApplyFlow（分配人设置表）
public class ApplyFlow {
	//申请单类型ID
	private Integer applyTypeID;
	//申请单类型名称
	private String applyTypeName;
	//分配人
	private String assigner;
	public Integer getApplyTypeID() {
		return applyTypeID;
	}
	public void setApplyTypeID(Integer applyTypeID) {
		this.applyTypeID = applyTypeID;
	}
	public String getApplyTypeName() {
		return applyTypeName;
	}
	public void setApplyTypeName(String applyTypeName) {
		this.applyTypeName = applyTypeName;
	}
	public String getAssigner() {
		return assigner;
	}
	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}
	
}
