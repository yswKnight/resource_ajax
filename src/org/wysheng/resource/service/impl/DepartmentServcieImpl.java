package org.wysheng.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.DepartmentDao;
import org.wysheng.resource.domain.Department;
import org.wysheng.resource.service.DepartmentService;

@Service
public class DepartmentServcieImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	//��ѯȫ��
	@Override
	public List<Department> finddeptAll() {
		return departmentDao.loadAll();
	}

	//ģ����ѯ
	@Override
	public List<Department> findAllByName(String deptname) {
		return departmentDao.findAllByName(deptname);
	}

	//���
	@Override
	public void addDept(Department department) {
		this.departmentDao.save(department);
	}

	//ɾ��
	@Override
	public void deleteDept(Integer deptid) {
		this.departmentDao.remove(deptid);
	}

	//�޸�
	@Override
	public void updateDept(Department dept) {
		this.departmentDao.update(dept);
	}

	//ID��ѯ
	@Override
	public Department findDeptById(Integer deptid) {
		return departmentDao.get(deptid);
	}
	
	@Override
	public Boolean findCountByDeptId(Integer deptid) {
		if(departmentDao.findCountByDeptId(deptid)==0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean finfCountByMan(String manager) {
		if(departmentDao.findCountByMan(manager)==0){
			return true;
		}else{
			return false;
		}
	}

}
