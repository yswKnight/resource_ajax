package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.OfficeEmailApply;

public interface OfficeEmailService {
	
	//��ȫ��
	public List<OfficeEmailApply> finOfficeEmailAll ();
	
	//ɾ��
	public void deleteOfficeEmail(Integer EmailID);
	
	//����޸�
	public void saveOrUpdate(OfficeEmailApply officeEmail);
	
	//���
	public void SaveOfficeEmail(OfficeEmailApply officeEmailApply,Apply apply);
	
	//�޸�
	public void UpdateOfficeEmail(OfficeEmailApply officeEmailApply);
}
