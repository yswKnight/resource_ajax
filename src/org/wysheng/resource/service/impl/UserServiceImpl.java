package org.wysheng.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.Page;
import org.wysheng.resource.dao.UserDao;
import org.wysheng.resource.domain.UserInfo;
import org.wysheng.resource.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	//根据用户名密码查询
	@Override
	public Boolean login(String username, String userpwd) {
		return userDao.findUserNameAndPwd(username, userpwd);
	}

	//根据ID查询类型
	@Override
	public Integer findTypeById(String id) {
		return userDao.findTypeById(id);
	}

	//根据部门ID查询员工姓名
	@Override
	public List<UserInfo> findNameByDeptId() {
		return userDao.findNameByDeptId();
	}

	//查询所有员工
	@Override
	public List<UserInfo> findUserAll() {
		return userDao.loadAll();
	}

	
	//删除员工
	@Override
	public void delete(String id) {
		this.userDao.remove(id);
	}

	//根据部门ID查询员工ID和姓名
	@Override
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid) {
		return userDao.findIDAndNameByDeptId(deptid);
	}
	
	//增加新员工
	@Override
	public void addUser(UserInfo user) {
		this.userDao.save(user);
	}

	//修改员工信息
	@Override
	public void update(UserInfo uesr) {
		this.userDao.update(uesr);
	}

	//ID查
	@Override
	public UserInfo findUserById(String id) {
		return userDao.get(id);
	}

	@Override
	public Boolean findId(String id) {
		return userDao.findUserById(id);
	}

	//分页
	@Override
	public Page<UserInfo> findUserAllForPage(Integer pageNo) {
		return userDao.listUsersForPage(pageNo);
	}

	//姓名模糊查询
	@Override
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo) {
		return userDao.findUserLikeName(name, pageNo);
	}

	
}
