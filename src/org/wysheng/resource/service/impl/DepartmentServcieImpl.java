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

	//查询全部
	@Override
	public List<Department> finddeptAll() {
		return departmentDao.loadAll();
	}

	//模糊查询
	@Override
	public List<Department> findAllByName(String deptname) {
		return departmentDao.findAllByName(deptname);
	}

	//添加
	@Override
	public void addDept(Department department) {
		this.departmentDao.save(department);
	}

	//删除
	@Override
	public void deleteDept(Integer deptid) {
		this.departmentDao.remove(deptid);
	}

	//修改
	@Override
	public void updateDept(Department dept) {
		this.departmentDao.update(dept);
	}

	//ID查询
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
