package org.wysheng.resource.domain;
/**
 * DeptID             NUMBER(6)            not null,--����ID
   DeptName           VARCHAR2(50),--��������
   Manager            CHAR(12),--���Ÿ�����
   DeptInfo           VARCHAR2(500),--��ע��Ϣ
   constraint PK_DEPARTMENT primary key (DeptID)--����ID���I
 * 
 * 
 * 
 * */
//Department�����ű�
public class Department {
	//����ID
	private Integer deptID;
	//��������
	private String deptName;
	//���Ÿ�����
	private String manager;
	//��ע��Ϣ
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
