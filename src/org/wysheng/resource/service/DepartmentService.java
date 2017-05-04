package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Department;

public interface DepartmentService {

	public List<Department> finddeptAll();
	
	public List<Department> findAllByName(String deptname);
	
	public void addDept(Department department);
	
	//ɾ��
	public void deleteDept(Integer deptid);
	
	//�޸�
	public void updateDept(Department dept);
	
	//����ID��ѯ��Ӧ�Ĳ�����Ϣ
	public Department findDeptById(Integer deptid);
	
	//��ѯ�����Ƿ����˴���
	public Boolean findCountByDeptId(Integer deptid);
	
	//��ѯ���ž���
	public Boolean finfCountByMan(String manager);
}
