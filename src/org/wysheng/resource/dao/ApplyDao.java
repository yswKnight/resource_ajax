package org.wysheng.resource.dao;

import org.springframework.stereotype.Repository;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.UserInfo;
@Repository
public class ApplyDao extends BaseDAO<Apply> {

	
	private final static  String ALL_APPLY = "from Apply where userID=?";
	
	private final static String ALL_APPLY_BY_STATUS="from Apply a where a.userID in (select u.userID from UserInfo u where u.deptID.deptID=? ) and a.applyStatus=0";
	
	private final static String ALL_APPLY_BY_STATUS1="from Apply a where a.applyTypeID.assigner=? and a.applyStatus=1";
	
	private final static String ALL_APPLY_BY_DEALER="from Apply a where a.applyTypeID.dealer=? and a.applyStatus=2";
	
	//∑÷“≥
	public Page<Apply> listUsersForPage(Integer pageNo,String userid){
		return this.executePage(ALL_APPLY, pageNo, 4,userid);
	}
	
	//…Û≈˙
	public Page<Apply> listApplyForPage(Integer pageNo,Integer deptid){
		return this.executePage(ALL_APPLY_BY_STATUS, pageNo, 2, deptid);
	}
	
	//∑÷≈‰
	public Page<Apply> listassignerForPage(Integer pageNo,String assigner){
		return this.executePage(ALL_APPLY_BY_STATUS1, pageNo, 2, assigner);
	}
}
