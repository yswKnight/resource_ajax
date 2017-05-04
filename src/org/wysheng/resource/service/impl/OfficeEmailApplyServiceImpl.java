package org.wysheng.resource.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.ApplyDao;
import org.wysheng.resource.dao.OfficeEmailApplyDao;
import org.wysheng.resource.dao.OperateLogDao;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.domain.OfficeEmailApply;
import org.wysheng.resource.domain.OperateLog;
import org.wysheng.resource.service.OfficeEmailService;

@Service("officeEmailService")
public class OfficeEmailApplyServiceImpl implements OfficeEmailService {
	
	@Autowired
	private OfficeEmailApplyDao officeEmailApplyDao;
	
	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private OperateLogDao operateLogDao;
	

	//根据主键ID删除
	@Override
	public void deleteOfficeEmail(Integer EmailID) {
		this.officeEmailApplyDao.remove(EmailID);
	}

	//查询全部信息
	@Override
	public List<OfficeEmailApply> finOfficeEmailAll() {
		return this.officeEmailApplyDao.loadAll();
	}

	//保存和修改
	@Override
	public void saveOrUpdate(OfficeEmailApply officeEmail) {
		this.officeEmailApplyDao.saveorupdate(officeEmail);
	}

	//保存
	@Override
	public void SaveOfficeEmail(OfficeEmailApply officeEmailApply,Apply apply) {
		
	}

	@Override
	public void UpdateOfficeEmail(OfficeEmailApply officeEmailApply) {
		this.officeEmailApplyDao.update(officeEmailApply);
	}

}
