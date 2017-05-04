package org.wysheng.resource.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.wysheng.resource.dao.ApplyDao;
import org.wysheng.resource.dao.IPAddressApplyDao;
import org.wysheng.resource.dao.OfficeEmailApplyDao;
import org.wysheng.resource.dao.OperateLogDao;
import org.wysheng.resource.dao.Page;
import org.wysheng.resource.dao.StorageSpaceApplyDao;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.domain.IPAddressApply;
import org.wysheng.resource.domain.OfficeEmailApply;
import org.wysheng.resource.domain.OperateLog;
import org.wysheng.resource.domain.StorageSpaceApply;
import org.wysheng.resource.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDao applyDao;
	
	@Autowired
	private IPAddressApplyDao ipAddressApplyDao;
	
	@Autowired
	private OfficeEmailApplyDao officeEmailApplyDao;
	
	@Autowired
	private StorageSpaceApplyDao storageSpaceApplyDao;
	
	@Autowired
	private OperateLogDao operateLogDao;
	
	@Override
	public Page<Apply> listUsersForPage(Integer pageNo,String id) {
		return applyDao.listUsersForPage(pageNo,id);
	}

	@Override
	public void deleteAppply(Integer id) {
		this.applyDao.remove(id);
	}

	//保存申请单
	@Override
	public void saveApply(Apply apply,Map<String , Object> map) {
		ApplyFlow applyFlow=new ApplyFlow();
		OperateLog operateLog=null;
		try {
			if(map.get("type")=="ip"){
				applyFlow.setApplyTypeID(1);
			}else if(map.get("type")=="email"){
				applyFlow.setApplyTypeID(2);
			}else{
				applyFlow.setApplyTypeID(3);
			}
			operateLog=new OperateLog();
			operateLog.setOperateType("提交申请");
			apply.setApplyTypeID(applyFlow);
			apply.setApplyStatus(0);
			apply.setApplyDate(new Date());
			applyDao.save(apply);
			if(map.get("type")=="ip"){
			((IPAddressApply) map.get("ip")).setApplyID(apply.getApplyID());
			ipAddressApplyDao.save((IPAddressApply) map.get("ip"));
			}else if(map.get("type")=="email"){
				((OfficeEmailApply) map.get("email")).setApplyID(apply.getApplyID());
				officeEmailApplyDao.save((OfficeEmailApply) map.get("email"));
			}else{
				((StorageSpaceApply) map.get("space")).setApplyID(apply.getApplyID());
				storageSpaceApplyDao.save((StorageSpaceApply) map.get("space"));
			}
			operateLog.setUserID(apply.getUserID());
			operateLog.setApplyID(apply);
			operateLog.setOperateDate(new Date());
			operateLog.setResult("提交成功");
		} catch (Exception e) {
			operateLog.setResult("提交失败");
		}finally{
			operateLogDao.save(operateLog);
		}
	}

	@Override
	public void updateApply(Apply apply) {
		this.applyDao.update(apply);
	}

	@Override
	public void saveorupdate(Apply apply) {
		this.applyDao.saveorupdate(apply);
	}

	
	
	@Override
	public Page<Apply> listApplyForPage(Integer pageNo, Integer deptid) {
		return this.applyDao.listApplyForPage(pageNo, deptid);
	}

	//审批
	@Override
	public void approval(Integer applyid, String type,String approval) {
		OperateLog log=null;
		try {
			if(type.equals("1")){
				Apply apply=this.applyDao.get(applyid);
				log=new OperateLog();
				log.setOperateDate(new Date());
				log.setOperateType("审批申请");
				log.setResult("审批通过");
				log.setUserID(approval);
				log.setApplyID(apply);
				apply.setApplyStatus(1);
				apply.setApprover(approval);
				operateLogDao.save(log);
				applyDao.update(apply);
			}else{
				Apply apply=this.applyDao.get(applyid);
				apply.setApplyStatus(4);
				apply.setApprover(approval);
				applyDao.update(apply);
				log=new OperateLog();
				log.setOperateDate(new Date());
				log.setOperateType("审批申请");
				log.setResult("审批否决");
				log.setUserID(approval);
				log.setApplyID(apply);
				operateLogDao.update(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//待分配分页显示
	@Override
	public Page<Apply> listassignerForPage(Integer pageNo, String assigner) {
		return this.applyDao.listassignerForPage(pageNo, assigner);
	}

	//分配申请单
	@Override
	public void assginer(Integer applyid, String assigner) {
		OperateLog log=null;
		Apply apply=this.applyDao.get(applyid);
		log=new OperateLog();
		log.setOperateDate(new Date());
		log.setOperateType("分配申请");
		log.setResult("分配完成");
		log.setUserID(assigner);
		log.setApplyID(apply);
		apply.setApplyStatus(2);
		apply.setAssigner(assigner);
		operateLogDao.save(log);
		applyDao.update(apply);
	}
	
}
