package org.wysheng.resource.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wysheng.resource.domain.Department;


@Repository
public class DepartmentDao extends BaseDAO<Department> {

	private static final String SELECT_ALL_FROM_NAME_LIKE="from Department d where d.deptName like ?";
	
	private static final String SELECT_COUNT_USER_BY_DEPTID="select count(*) from UserInfo u where u.deptID.deptID=?";
	
	private static final String SELECT_MANAGER="select count(*) from Department u where u.manager=?";
	
	@SuppressWarnings("unchecked")
	public List<Department> findAllByName(String deptname){
		List<Department> list=this.find(SELECT_ALL_FROM_NAME_LIKE, "%"+deptname+"%");
		return list;
	}
	
	//查询部门是否有人存在
	@SuppressWarnings("unchecked")
	public long findCountByDeptId(Integer deptid){
		long num=0;
		try {
			List list=this.find(SELECT_COUNT_USER_BY_DEPTID,deptid);
			num=(Long) list.get(0);
			System.out.println("人数:"+num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public long findCountByMan(String manager){
		long num=0;
		try {
			List list=this.find(SELECT_MANAGER,manager);
			num=(Long) list.get(0);
			System.out.println("人数:"+num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
}
