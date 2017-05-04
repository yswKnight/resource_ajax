package org.wysheng.resource.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.Apply;
import org.wysheng.resource.domain.IPAddressApply;
import org.wysheng.resource.domain.OfficeEmailApply;
import org.wysheng.resource.domain.StorageSpaceApply;
import org.wysheng.resource.service.ApplyService;

/*************************
 * 
 * @author wulang
 *
 */
@Controller
@Scope("prototype")
public class ApplyAction extends BaseAction {
	
	@Autowired
	private ApplyService applyService;
	
	private HttpServletRequest request=ServletActionContext.getRequest();

	//分页显示全部
	public String list() throws Exception {
		String id=request.getParameter("Id");
		Page<Apply> page=applyService.listUsersForPage(Integer.parseInt(this.getPageNo()), id);
		getResult().put("apply", page);
		this.resandresp();
		return null;
	}
	
	//分页显示所有待审批的申请单
	public String listSP() throws Exception {
		Integer deptid=Integer.parseInt(request.getParameter("deptID"));
		Page<Apply> list=applyService.listApplyForPage(Integer.parseInt(this.getPageNo()), deptid);
		getResult().put("ListSP", list);
		this.resandresp();
		return null;
	}
	
	//分页显示所有待分配的申请单
	public String listFP() throws Exception {
		String userid=request.getParameter("userid");
		Page<Apply> list=applyService.listassignerForPage(Integer.parseInt(pageNo), userid);
		getResult().put("ListFP", list);
		this.resandresp();
		return null;
	}
	
	//保存申请单
	public String save() throws Exception {
		String result="";
		try {
			if(null!=ipAddressApply){
				map.put("type", "ip");
				map.put("ip", ipAddressApply);
			}else if(null!=emailApply){
				map.put("type", "email");
				map.put("email", emailApply);
			}else{
				map.put("type", "space");
				map.put("space", storageSpaceApply);
			}
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		this.applyService.saveApply(apply, map);
		getResult().put("result", result);
		this.resandresp();
		return null;
	}
	
	//审批申请单
	public String approval() throws Exception {
		Integer applyid=Integer.parseInt(request.getParameter("appID"));
		String type=request.getParameter("type");
		String userid=request.getParameter("userID");
		System.out.println(applyid+type+userid);
		String result="";
		try {
			this.applyService.approval(applyid, type,userid);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		getResult().put("result", result);
		this.resandresp();
		return null;
	}
	
	//分配申请单
	public String assginer() throws Exception {
		Integer appid=Integer.parseInt(request.getParameter("appid"));
		String assginer=request.getParameter("assginer");
		String result="";
		try {
			this.applyService.assginer(appid, assginer);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		getResult().put("result", result);
		this.resandresp();
		return null;
	}
	private String pageNo="1";

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	private Map<String , Object> map=new HashMap<String ,Object >();
	
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	private OfficeEmailApply emailApply;
	
	private IPAddressApply ipAddressApply;
	
	private StorageSpaceApply storageSpaceApply;
	
	private Apply apply;

	public OfficeEmailApply getEmailApply() {
		return emailApply;
	}

	public void setEmailApply(OfficeEmailApply emailApply) {
		this.emailApply = emailApply;
	}

	public IPAddressApply getIpAddressApply() {
		return ipAddressApply;
	}

	public void setIpAddressApply(IPAddressApply ipAddressApply) {
		this.ipAddressApply = ipAddressApply;
	}



	public StorageSpaceApply getStorageSpaceApply() {
		return storageSpaceApply;
	}

	public void setStorageSpaceApply(StorageSpaceApply storageSpaceApply) {
		this.storageSpaceApply = storageSpaceApply;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}
	

	
}
