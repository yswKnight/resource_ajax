package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.OperateLog;

public interface OperateLogService {

	//查全部
	public List<OperateLog> findLogALl();
	
	//删除
	public void deleteLog(Integer id);
	
	//修改添加
	public void SaveOrUpdate(OperateLog Log1);
	
	//添加
	public void SaveLog(OperateLog operateLog);
	
	//修改
	public void UpdateLog(OperateLog operateLog);
	
	
}
