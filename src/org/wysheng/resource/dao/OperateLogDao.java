package org.wysheng.resource.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.wysheng.resource.domain.OperateLog;


@Repository
public class OperateLogDao extends BaseDAO<OperateLog> {
	
	private static final String SELECT_LOG_BY_APPLYID="from OperateLog o where o.applyID.applyID=? and operateType='Ã·Ωª…Í«Î'";
	
	@SuppressWarnings("unchecked")
	public OperateLog finLogByApplyid(Integer applyid){
		List<OperateLog> list=this.find(SELECT_LOG_BY_APPLYID, applyid);
		OperateLog log=list.get(0);
		return log;
	}
}
