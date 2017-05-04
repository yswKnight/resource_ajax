package org.wysheng.resource.service;

import java.util.List;

import org.wysheng.resource.domain.ApplyFlow;

public interface ApplyFlowService {
	
	public List<ApplyFlow> findAppFLAll();
	
	public void update(ApplyFlow applyflow);
}
