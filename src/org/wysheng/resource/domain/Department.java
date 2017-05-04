package org.wysheng.resource.domain;
/**
 * DeptID             NUMBER(6)            not null,--部门ID
   DeptName           VARCHAR2(50),--部门名称
   Manager            CHAR(12),--部门负责人
   DeptInfo           VARCHAR2(500),--备注信息
   constraint PK_DEPARTMENT primary key (DeptID)--部门ID主鍵
 * 
 * 
 * 
 * */
//Department（部门表）
public class Department {
	//部门ID
	private Integer deptID;
	//部门名称
	private String deptName;
	//部门负责人
	private String manager;
	//备注信息
	private String deptInfo;
	
	public Integer getDeptID() {
		return deptID;
	}
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(String deptInfo) {
		this.deptInfo = deptInfo;
	}


}
