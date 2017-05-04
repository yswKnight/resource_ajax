package org.wysheng.resource.web.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	
	protected void resandresp(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out=response.getWriter();
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			System.out.println(gson.toJson(result));
			out.print(gson.toJson(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
	
	protected Map<String, Object> result = new HashMap<String, Object>();

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	 
	 

}
