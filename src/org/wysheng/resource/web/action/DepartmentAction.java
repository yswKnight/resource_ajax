package org.wysheng.resource.web.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wysheng.resource.domain.Department;
import org.wysheng.resource.service.DepartmentService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class DepartmentAction extends ActionSupport {
	
	@Autowired
	private DepartmentService departmentService;

	private HttpServletRequest request=ServletActionContext.getRequest();
	
	private HttpServletResponse response=ServletActionContext.getResponse();
	
	//查询部门经理
	public String findMan() throws Exception {
		String userid=request.getParameter("userID");
		PrintWriter out=response.getWriter();
		String result="";
		if(departmentService.finfCountByMan(userid)){
			result="success";
		}else{
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}

	//查询全部部门
	public String list() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		List<Department> list=departmentService.finddeptAll();
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(list));
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	//根据部门名称模糊查询
	public String findByName() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		String deptname=request.getParameter("deptName");
		List<Department> list=departmentService.findAllByName(deptname);
		Gson gson=new Gson();
		out.print(gson.toJson(list));
		out.flush();
		out.close();
		return null;
	}
	
	//保存
	public String save() throws Exception {
		String result="";
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		try {
			System.out.println(this.department.getDeptID());
			if(this.department.getDeptID()!=null){
				departmentService.updateDept(department);
				result="success";
			}else{
			departmentService.addDept(this.department);
			result="success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	
	//删除部门
	public String delete() throws Exception {
		PrintWriter out=response.getWriter();
		Integer deptid=Integer.parseInt(request.getParameter("Id"));
		String result="";
		try {
			if(departmentService.findCountByDeptId(deptid)){
			this.departmentService.deleteDept(deptid);
			result="success";
			}else{
				result="error";
			}
			
		} catch (Exception e) {
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	
	//ID查询
	public String findById() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		Integer id=Integer.parseInt(request.getParameter("Id"));
		Department dept=departmentService.findDeptById(id);
		result.put("dept", dept);
		Gson gson=new Gson();
		out.print(gson.toJson(result));
		out.flush();
		out.close();
		return null;
	}
	
	private Map<String, Object> result = new HashMap<String, Object>();
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
