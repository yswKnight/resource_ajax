package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.OperateLog;

public interface OperateLogService {

	//��ȫ��
	public List<OperateLog> findLogALl();
	
	//ɾ��
	public void deleteLog(Integer id);
	
	//�޸����
	public void SaveOrUpdate(OperateLog Log1);
	
	//���
	public void SaveLog(OperateLog operateLog);
	
	//�޸�
	public void UpdateLog(OperateLog operateLog);
	
	
}
