package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.StorageSpaceApply;

public interface StorageSpaceService {

	//��ȫ��
	public List<StorageSpaceApply> findSpaceAll();
	
	//ɾ��
	public void deleteSpace(Integer id);
	
	//���
	public void Save(StorageSpaceApply space,Apply apply);
	
	//�޸�
}
