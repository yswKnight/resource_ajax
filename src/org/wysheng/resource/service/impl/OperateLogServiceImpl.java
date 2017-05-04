package org.wysheng.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.OperateLogDao;
import org.wysheng.resource.service.OperateLogService;

@Service("operateLogService")
public class OperateLogServiceImpl implements OperateLogService {
	
	@Autowired
	private OperateLogDao operateLogDao;

	//����޸�
	@Override
	public void SaveOrUpdate(org.wysheng.resource.domain.OperateLog Log) {

	}

	//ɾ��
	@Override
	public void deleteLog(Integer id) {
		// TODO Auto-generated method stub

	}

	//��ѯȫ��
	@Override
	public List<org.wysheng.resource.domain.OperateLog> findLogALl() {
		return this.operateLogDao.loadAll();
	}

	@Override
	public void SaveLog(org.wysheng.resource.domain.OperateLog operateLog) {
		this.operateLogDao.save(operateLog);
	}

	@Override
	public void UpdateLog(org.wysheng.resource.domain.OperateLog operateLog) {
		this.operateLogDao.update(operateLog);
	}

}
