package org.wysheng.resource.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.ApplyDao;
import org.wysheng.resource.dao.OperateLogDao;
import org.wysheng.resource.dao.StorageSpaceApplyDao;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.domain.OperateLog;
import org.wysheng.resource.domain.StorageSpaceApply;
import org.wysheng.resource.service.StorageSpaceService;

@Service
public class StorageSpaceServiceImpl implements StorageSpaceService {
	
	@Autowired
	private StorageSpaceApplyDao storageSpaceApplyDao;
	
	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private OperateLogDao operateLogDao;

	//添加
	@Override
	public void Save(StorageSpaceApply space,Apply apply) {
		
	}

	//删除
	@Override
	public void deleteSpace(Integer id) {
		this.storageSpaceApplyDao.remove(id);
	}

	//查询全部
	@Override
	public List<StorageSpaceApply> findSpaceAll() {
		return this.storageSpaceApplyDao.loadAll();
	}

}
