package org.wysheng.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.ApplyFlowDao;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.service.ApplyFlowService;

@Service
public class ApplyFlowServiceImpl implements ApplyFlowService {
	
	@Autowired
	private ApplyFlowDao applyFlowDao;

	//查询所有申请单
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyFlow> findAppFLAll() {
		return applyFlowDao.find("from ApplyFlow");
	}

	@Override
	public void update(ApplyFlow applyflow) {
		this.applyFlowDao.update(applyflow);
	}

}
