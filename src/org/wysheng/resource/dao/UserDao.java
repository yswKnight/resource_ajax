package org.wysheng.resource.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wysheng.resource.domain.UserInfo;

@Repository
public class UserDao extends BaseDAO<UserInfo> {
	
	private final static  String ALL_USERS = "from UserInfo";

	private static final String SELECT_USERNAME_AND_PWD="from UserInfo u where u.userID=? and u.password=?";
	
	private static final String SELECT_TYPE_BY_ID="select type from UserInfo u where u.userID=? ";
	
	private static final String SELECT_ID_NAME_BY_DEPTID="select u.userID,u.name from UserInfo u where u.deptID.deptID=?";
	
	private static final String SELECT_USER_BY_ID="from UserInfo u where u.userID=?";
	
	private static final String SELECT_USER_LIKE_NAME="from UserInfo u where u.name like ?";
	
	
	
	
	//根据用户名和密码查询对应的数据
	@SuppressWarnings("unchecked")
	public Boolean findUserNameAndPwd(String username,String pwd){
		List list=this.find(SELECT_USERNAME_AND_PWD,username,pwd);
		System.out.println(list.toString());
		if(list.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//根据ID查询员工类型
	public Integer findTypeById(String id){
		Integer type=Integer.parseInt(this.find(SELECT_TYPE_BY_ID, id).get(0).toString());
		return type;
	}
	
	//根据指定的部门ID查询员工姓名和工号
	@SuppressWarnings("unchecked")
	public List<UserInfo> findNameByDeptId(){
		List<UserInfo> list=this.find(SELECT_ID_NAME_BY_DEPTID,20);
		return list;
	}
	
	//根据部门编号查询员工ID和姓名
	@SuppressWarnings("unchecked")
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid){
		List<UserInfo> list=this.find(SELECT_ID_NAME_BY_DEPTID, deptid);
		return list;
	}
	
	//查询该ID是否已存在
	public Boolean findUserById(String userID){
		List list=this.find(SELECT_USER_BY_ID,userID);
		System.out.println(list.toString());
		if(list.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//分页
	public Page<UserInfo> listUsersForPage(Integer pageNo){
		return this.executePage(ALL_USERS, pageNo, 8);
	}
	
	//名字模糊查询
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo){
		if(name == null){
			name = "";
		}else{
			name = "%" +name.trim() + "%";
		}
		return this.executePage(SELECT_USER_LIKE_NAME, pageNo, 8,name);
	}
	
	
}
