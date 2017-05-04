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

	//�����û��������ѯ
	@Override
	public Boolean login(String username, String userpwd) {
		return userDao.findUserNameAndPwd(username, userpwd);
	}

	//����ID��ѯ����
	@Override
	public Integer findTypeById(String id) {
		return userDao.findTypeById(id);
	}

	//���ݲ���ID��ѯԱ������
	@Override
	public List<UserInfo> findNameByDeptId() {
		return userDao.findNameByDeptId();
	}

	//��ѯ����Ա��
	@Override
	public List<UserInfo> findUserAll() {
		return userDao.loadAll();
	}

	
	//ɾ��Ա��
	@Override
	public void delete(String id) {
		this.userDao.remove(id);
	}

	//���ݲ���ID��ѯԱ��ID������
	@Override
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid) {
		return userDao.findIDAndNameByDeptId(deptid);
	}
	
	//������Ա��
	@Override
	public void addUser(UserInfo user) {
		this.userDao.save(user);
	}

	//�޸�Ա����Ϣ
	@Override
	public void update(UserInfo uesr) {
		this.userDao.update(uesr);
	}

	//ID��
	@Override
	public UserInfo findUserById(String id) {
		return userDao.get(id);
	}

	@Override
	public Boolean findId(String id) {
		return userDao.findUserById(id);
	}

	//��ҳ
	@Override
	public Page<UserInfo> findUserAllForPage(Integer pageNo) {
		return userDao.listUsersForPage(pageNo);
	}

	//����ģ����ѯ
	@Override
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo) {
		return userDao.findUserLikeName(name, pageNo);
	}

	
}
