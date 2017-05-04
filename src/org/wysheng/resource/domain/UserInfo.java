package org.wysheng.resource.domain;
/***
 * UserID             CHAR(12)             not null,--�û�ID
   Name               VARCHAR2(50),--�û�����
   Password           VARCHAR2(50),--����
   Email              VARCHAR2(50),--�����ʼ�
   Telephone          VARCHAR2(50),--�绰
   Type               NUMBER(8),--�û�����
   DeptID             NUMBER(8),--����ID
   constraint PK_USER primary key (UserID)--�û�ID���I
 * 
 * 
 * */
//�û���
public class UserInfo {
	//�û�ID
      private String userID;
      //�û�����
      private String name;
      //����
      private String password;
      //�����ʼ�
      private String email;
      //�绰
      private String telephone;
      //�û�����
      private Integer type;
      //����ID
      private Department deptID;
      
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Department getDeptID() {
		return deptID;
	}
	public void setDeptID(Department deptID) {
		this.deptID = deptID;
	}

}
