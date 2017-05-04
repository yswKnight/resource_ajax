package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.OfficeEmailApply;

public interface OfficeEmailService {
	
	//差全部
	public List<OfficeEmailApply> finOfficeEmailAll ();
	
	//删除
	public void deleteOfficeEmail(Integer EmailID);
	
	//添加修改
	public void saveOrUpdate(OfficeEmailApply officeEmail);
	
	//添加
	public void SaveOfficeEmail(OfficeEmailApply officeEmailApply,Apply apply);
	
	//修改
	public void UpdateOfficeEmail(OfficeEmailApply officeEmailApply);
}
