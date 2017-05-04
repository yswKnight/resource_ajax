package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.UserInfo;

public interface UserService {

	//��¼��֤
	public Boolean login(String username,String userpwd);
	
	//����Ա��ID��ѯԱ������
	public Integer findTypeById(String id);
	
	
	//���ݲ���ID��ѯԱ������
	public List<UserInfo> findNameByDeptId();
	
	//��ѯ����Ա��
	public List<UserInfo> findUserAll();
	
	//ɾ��Ա��
	public void delete(String id);
	
	//���ݲ��ű�Ų�ѯԱ��ID������
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid);
	
	//�����Ա��
	public void addUser(UserInfo user);
	
	//�޸�Ա����Ϣ
	public void update(UserInfo uesr);
	
	//ID��
	public UserInfo findUserById(String id);
	
	//��ѯ��ID�Ƿ��Ѵ���
	public Boolean findId(String id);
	
	//��ҳ
	public Page<UserInfo> findUserAllForPage(Integer pageNo);
	
	//����ģ����ѯ
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo);
	
	
	
}
