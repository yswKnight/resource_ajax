package org.wysheng.resource.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.ApplyDao;
import org.wysheng.resource.dao.IPAddressApplyDao;
import org.wysheng.resource.dao.OperateLogDao;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.domain.IPAddressApply;
import org.wysheng.resource.domain.OperateLog;
import org.wysheng.resource.service.IPAddressApplyService;

@Service
public class IPAddressApplyServiceImpl implements IPAddressApplyService {
	
	@Autowired
	private IPAddressApplyDao iPAddressApplyDao;
	
	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private OperateLogDao operateLogDao;

	//保存
	@Override
	public void Save(IPAddressApply ip,Apply apply) {
		
	}

	//根据主键ID删除信息
	@Override
	public void deleteIP(Integer IPID) {
		this.iPAddressApplyDao.remove(IPID);
	}

	//查询全部日志信息
	@Override
	public List<IPAddressApply> findIPAll() {
		return this.iPAddressApplyDao.loadAll();
	}

}
