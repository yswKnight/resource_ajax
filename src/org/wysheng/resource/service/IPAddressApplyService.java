package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.IPAddressApply;

public interface IPAddressApplyService {

	//��ȫ��
	public List<IPAddressApply> findIPAll();
	
	//ɾ��
	public void deleteIP(Integer IPID);
	
	//���
	public void Save(IPAddressApply ip,Apply apply);
	
	
}
