package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.IPAddressApply;

public interface IPAddressApplyService {

	//²îÈ«²¿
	public List<IPAddressApply> findIPAll();
	
	//É¾³ý
	public void deleteIP(Integer IPID);
	
	//Ìí¼Ó
	public void Save(IPAddressApply ip,Apply apply);
	
	
}
