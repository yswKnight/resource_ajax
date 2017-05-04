package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.UserInfo;

public interface UserService {

	//登录验证
	public Boolean login(String username,String userpwd);
	
	//根据员工ID查询员工类型
	public Integer findTypeById(String id);
	
	
	//根据部门ID查询员工姓名
	public List<UserInfo> findNameByDeptId();
	
	//查询所有员工
	public List<UserInfo> findUserAll();
	
	//删除员工
	public void delete(String id);
	
	//根据部门编号查询员工ID和姓名
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid);
	
	//添加新员工
	public void addUser(UserInfo user);
	
	//修改员工信息
	public void update(UserInfo uesr);
	
	//ID查
	public UserInfo findUserById(String id);
	
	//查询此ID是否已存在
	public Boolean findId(String id);
	
	//分页
	public Page<UserInfo> findUserAllForPage(Integer pageNo);
	
	//姓名模糊查询
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo);
	
	
	
}
