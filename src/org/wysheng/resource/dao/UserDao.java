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
	
	
	
	
	//�����û����������ѯ��Ӧ������
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
	
	//����ID��ѯԱ������
	public Integer findTypeById(String id){
		Integer type=Integer.parseInt(this.find(SELECT_TYPE_BY_ID, id).get(0).toString());
		return type;
	}
	
	//����ָ���Ĳ���ID��ѯԱ�������͹���
	@SuppressWarnings("unchecked")
	public List<UserInfo> findNameByDeptId(){
		List<UserInfo> list=this.find(SELECT_ID_NAME_BY_DEPTID,20);
		return list;
	}
	
	//���ݲ��ű�Ų�ѯԱ��ID������
	@SuppressWarnings("unchecked")
	public List<UserInfo> findIDAndNameByDeptId(Integer deptid){
		List<UserInfo> list=this.find(SELECT_ID_NAME_BY_DEPTID, deptid);
		return list;
	}
	
	//��ѯ��ID�Ƿ��Ѵ���
	public Boolean findUserById(String userID){
		List list=this.find(SELECT_USER_BY_ID,userID);
		System.out.println(list.toString());
		if(list.size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	//��ҳ
	public Page<UserInfo> listUsersForPage(Integer pageNo){
		return this.executePage(ALL_USERS, pageNo, 8);
	}
	
	//����ģ����ѯ
	public Page<UserInfo> findUserLikeName(String name,Integer pageNo){
		if(name == null){
			name = "";
		}else{
			name = "%" +name.trim() + "%";
		}
		return this.executePage(SELECT_USER_LIKE_NAME, pageNo, 8,name);
	}
	
	
}
