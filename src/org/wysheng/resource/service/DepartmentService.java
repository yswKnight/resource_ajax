package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Department;

public interface DepartmentService {

	public List<Department> finddeptAll();
	
	public List<Department> findAllByName(String deptname);
	
	public void addDept(Department department);
	
	//删除
	public void deleteDept(Integer deptid);
	
	//修改
	public void updateDept(Department dept);
	
	//根据ID查询对应的部门信息
	public Department findDeptById(Integer deptid);
	
	//查询部门是否有人存在
	public Boolean findCountByDeptId(Integer deptid);
	
	//查询部门经理
	public Boolean finfCountByMan(String manager);
}
