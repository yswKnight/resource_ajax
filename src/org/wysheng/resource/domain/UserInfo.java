package org.wysheng.resource.domain;
/***
 * UserID             CHAR(12)             not null,--用户ID
   Name               VARCHAR2(50),--用户名称
   Password           VARCHAR2(50),--密码
   Email              VARCHAR2(50),--电子邮件
   Telephone          VARCHAR2(50),--电话
   Type               NUMBER(8),--用户类型
   DeptID             NUMBER(8),--部门ID
   constraint PK_USER primary key (UserID)--用户ID主鍵
 * 
 * 
 * */
//用户表
public class UserInfo {
	//用户ID
      private String userID;
      //用户名称
      private String name;
      //密码
      private String password;
      //电子邮件
      private String email;
      //电话
      private String telephone;
      //用户类型
      private Integer type;
      //部门ID
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
