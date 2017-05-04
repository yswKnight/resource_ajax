package org.wysheng.resource.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wysheng.resource.domain.ApplyFlow;
import org.wysheng.resource.service.ApplyFlowService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/************
 * 
 * @author wulang
 *
 */
@Controller
@Scope("prototype")
public class ApplyFlowAction extends ActionSupport {
	
	@Autowired
	private ApplyFlowService applyFlowServcie;
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	
	private HttpServletResponse response=ServletActionContext.getResponse();
	
	//ÏÔÊ¾È«²¿
	public String list() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		List<ApplyFlow> list=applyFlowServcie.findAppFLAll(); 
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(list));
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	public String update() throws Exception {
		String result="";
		try {
			this.applyFlowServcie.update(this.applyflow);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		response.getWriter().print(result);
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	private Map<String, Object> result = new HashMap<String, Object>();
	private ApplyFlow applyflow;
	
	

	public ApplyFlow getApplyflow() {
		return applyflow;
	}

	public void setApplyflow(ApplyFlow applyflow) {
		this.applyflow = applyflow;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	
}
