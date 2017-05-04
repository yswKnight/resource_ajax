package org.wysheng.resource.service;

import java.util.Map;

import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.Apply;

public interface ApplyService {

	//��ҳ��ʾ�������뵥
	public Page<Apply> listUsersForPage(Integer pageNo,String id);
	
	//��ҳ��ʾ���д����������뵥
	public Page<Apply> listApplyForPage(Integer pageNo,Integer deptid);
	
	//��ҳ��ʾ���д���������뵥
	public Page<Apply> listassignerForPage(Integer pageNo,String assigner);
	
	//ɾ�����뵥
	public void deleteAppply(Integer id);
	
	//�������뵥
	public void saveApply(Apply apply,Map<String , Object> map);
	
	//�޸����뵥
	public void updateApply(Apply apply);
	
	
	public void saveorupdate(Apply apply); 
	
	//����
	public void approval(Integer applyid,String type,String approval);
	
	//����
	public void assginer(Integer applyid,String assigner);
}
