package org.wysheng.resource.domain;
/*
 * ApplyID            NUMBER(8)              not null,--���뵥ID
   Zone               NUMBER(8),--�ռ�
   OfficePlace        VARCHAR2(50),--�칫�ص�
   UserName           VARCHAR2(50),--ʹ��������
   FullName           VARCHAR2(50),--����ȫƴ
   constraint PK_OFFICEEMAILAPPLY primary key (ApplyID)
 * 
 * 
 * **/
//OfficeEmailApply���칫�������뵥��
public class OfficeEmailApply {
	//���뵥ID
	private Integer applyID;
	//�ռ�
	private Integer zone;
	//�칫�ص�
	private String officePlace;
	//ʹ��������
	private String userName;
	//����ȫƴ
	private String fullName;

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
	public String getOfficePlace() {
		return officePlace;
	}
	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	

}
