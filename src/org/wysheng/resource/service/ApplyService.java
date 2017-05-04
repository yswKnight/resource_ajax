package org.wysheng.resource.service;

import java.util.Map;

import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.Apply;

public interface ApplyService {

	//分页显示所有申请单
	public Page<Apply> listUsersForPage(Integer pageNo,String id);
	
	//分页显示所有待审批的申请单
	public Page<Apply> listApplyForPage(Integer pageNo,Integer deptid);
	
	//分页显示所有待分配的申请单
	public Page<Apply> listassignerForPage(Integer pageNo,String assigner);
	
	//删除申请单
	public void deleteAppply(Integer id);
	
	//保存申请单
	public void saveApply(Apply apply,Map<String , Object> map);
	
	//修改申请单
	public void updateApply(Apply apply);
	
	
	public void saveorupdate(Apply apply); 
	
	//审批
	public void approval(Integer applyid,String type,String approval);
	
	//分配
	public void assginer(Integer applyid,String assigner);
}
