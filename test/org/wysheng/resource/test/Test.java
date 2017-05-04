package org.wysheng.resource.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.service.ApplyService;
import org.wysheng.resource.service.OfficeEmailService;
import org.wysheng.resource.service.OperateLogService;

import com.google.gson.Gson;

public class Test {
	

	@Autowired
	private OfficeEmailService officeEmailService;
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private OperateLogService operateLogService;
	
	@Before
	public void init() {
		ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		officeEmailService=act.getBean("officeEmailService", OfficeEmailService.class);
		applyService=act.getBean("applyService", ApplyService.class);
		operateLogService=act.getBean("operateLogService", OperateLogService.class);
	}


	/*@org.junit.Test
	public void test(){
		ApplyFlow applyFlow=new ApplyFlow();
		Apply apply=new Apply();
		OfficeEmailApply officeEmail=new OfficeEmailApply();
		OperateLog operateLog=new OperateLog();
		applyFlow.setApplyTypeID(1);
		apply.setApplyTypeID(applyFlow);
		apply.setApplyStatus(0);
		apply.setApplyTitle("IP地址申请");
		apply.setUserID("haha");
		apply.setApprover("lisi");
		apply.setPhone("110");
		apply.setApplyDate(new Date());
		apply.setApplyReason("新兵蛋子上岗");
		this.applyService.saveorupdate(apply);
		officeEmail.setApplyID(apply.getApplyID());
		officeEmail.setFullName("1212");
		officeEmail.setZone(2000);
		officeEmail.setOfficePlace("313");
		officeEmail.setUserName("2222");
		operateLog.setUserID("haha");
		operateLog.setApplyID(apply);
		operateLog.setOperateDate(new Date());
		operateLog.setResult("提交成功");
		operateLog.setDescribe("fadfsa");
		operateLog.setOperateType("IP地址申请单");
		this.operateLogService.SaveLog(operateLog);
	}*/
	
	@org.junit.Test
	public void test1(){
		String name="wangwu";
		Page<Apply> page=applyService.listassignerForPage(1, name);
		System.out.println(new Gson().toJson(page));
	}
}
