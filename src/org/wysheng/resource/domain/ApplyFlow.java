package org.wysheng.resource.domain;
/*
 * ApplyTypeID        NUMBER(6)            not null,--���뵥����ID
ApplyTypeName      VARCHAR2(50),--���뵥��������
Assigner           CHAR(12),--������ID
constraint PK_APPLYFLOW primary key (ApplyTypeID)--���뵥����ID���I
 * 
 * 
 * 
 * */
//ApplyFlow�����������ñ�
public class ApplyFlow {
	//���뵥����ID
	private Integer applyTypeID;
	//���뵥��������
	private String applyTypeName;
	//������
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
