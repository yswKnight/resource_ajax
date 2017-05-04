package org.wysheng.resource.domain;
/*
 * ApplyID            NUMBER(8)              not null,--申请单ID
   Zone               NUMBER(8),--空间
   OfficePlace        VARCHAR2(50),--办公地点
   UserName           VARCHAR2(50),--使用者姓名
   FullName           VARCHAR2(50),--姓名全拼
   constraint PK_OFFICEEMAILAPPLY primary key (ApplyID)
 * 
 * 
 * **/
//OfficeEmailApply（办公邮箱申请单）
public class OfficeEmailApply {
	//申请单ID
	private Integer applyID;
	//空间
	private Integer zone;
	//办公地点
	private String officePlace;
	//使用者姓名
	private String userName;
	//姓名全拼
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
