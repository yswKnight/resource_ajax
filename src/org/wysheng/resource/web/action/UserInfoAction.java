package org.wysheng.resource.web.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.wysheng.resource.dao.Page;
import org.wysheng.resource.domain.UserInfo;
import org.wysheng.resource.service.UserService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserInfoAction extends ActionSupport {

	/**
	 * 用户表
	 */
	private static final long serialVersionUID = 2583101930494407019L;
	
	@Autowired
	private UserService userService;
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	
	private HttpServletResponse response=ServletActionContext.getResponse();

	//修改密码
	public String updatePwd() throws Exception {
		String result="";
		try {
			String pwd=request.getParameter("Pwd");
			String id=request.getParameter("Id");
			this.setUserInfo(userService.findUserById(id));
			this.getUserInfo().setPassword(pwd);
			this.userService.update(userInfo);
			result="success";
		} catch (Exception e) {
			result="error";
		}
		response.getWriter().print(result);
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	//员工登录
	public String login() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		response.setContentType("application/json;charset=utf-8");
		Boolean num=userService.login(userInfo.getUserID(), userInfo.getPassword());
		if(num==false){
			this.setUserInfo(this.userService.findUserById(this.userInfo.getUserID()));
			Integer type=userService.findTypeById(userInfo.getUserID());
			result.put("type", type);
			session.put("userinfo", userInfo);
			result.put("msg", "success");
		}else{
			result.put("msg", "error");
		}
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(result));
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	//退出登录
	public String exit() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("userinfo");
		return null;
	}
	
	//查询IT支持部的所有员工
	public String listname() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		List<UserInfo> list=userService.findNameByDeptId();
		Gson gson=new Gson();
		System.out.println(gson.toJson(list));
		response.getWriter().print(gson.toJson(list));
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	
	//查询所有员工
	public String list() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		List<UserInfo> list1=userService.findUserAll();
		Gson gson=new Gson();
		response.getWriter().print(gson.toJson(list1));
		response.getWriter().flush();
		response.getWriter().close();
		return null;
	}
	//删除员工
	public String delete() throws Exception {
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("Id");
		System.out.println(userid);
		String result="";
		try {
			this.userService.delete(userid);
			result="success";
			
		} catch (Exception e) {
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	//根据部门编号查询员工ID和姓名
	public String findNameAndIdByDeptId() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		Integer Id=Integer.parseInt(request.getParameter("Id"));
		List<UserInfo> list=userService.findIDAndNameByDeptId(Id);
		JSONArray array=new JSONArray(list);
		System.out.println(array);
		out.print(array);
		out.flush();
		out.close();
		return null;
	}
	
	//保存员工信息
	public String save() throws Exception {
		String result="";
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(this.userInfo.getDeptID().getDeptID()==10){
			userInfo.setType(0);
		}else{
			userInfo.setType(1);
		}
		try {
			this.userInfo.setPassword("123");
			this.userService.addUser(this.userInfo);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	
	//ID查
	public String findUserById() throws Exception {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("Id");
		UserInfo user=userService.findUserById(id);
		result.put("user", user);
		Gson gson=new Gson();
		System.out.println(gson.toJson(result));
		out.print(gson.toJson(result));
		out.flush();
		out.close();
		return null;
	}
	
	//验证用户是否已存在
	public String findById() throws Exception {
		String result="";
		PrintWriter out=response.getWriter();
		String Id=request.getParameter("Id");
		if(userService.findId(Id)){
			result="success";//用户名可以使用
		}else{
			result="error";//用户名已存在
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	
	//修改员工信息
	public String update() throws Exception {
		String result="";
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		if(this.userInfo.getDeptID().getDeptID()==10){
			userInfo.setType(0);
		}else{
			userInfo.setType(1);
		}
		try {
			this.userService.update(userInfo);
			result="success";
		} catch (Exception e) {
			e.printStackTrace();
			result="error";
		}
		out.print(result);
		out.flush();
		out.close();
		return null;
	}
	
	//分页
	public String fenye() throws Exception {
		// 查询所有人分页
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		page = userService.findUserAllForPage(Integer.parseInt(pageNo));
		List<UserInfo> list=page.getResult();
		Integer pageTotal=(int)page.getPageTotal();
		result.put("user1", list);
		result.put("pageTotal", pageTotal);
		Gson gson=new Gson();
		out.print(gson.toJson(result));
		out.flush();
		out.close();
		return null;
	}
	
	//姓名模糊查询
	public String findUserLikeName() throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		String Name=request.getParameter("Name");
		page=this.userService.findUserLikeName(Name,Integer.parseInt(pageNo));
		List<UserInfo> list=page.getResult();
		Integer pageTotal=(int)page.getPageTotal();
		result.put("user1", list);
		result.put("pageTotal", pageTotal);
		Gson gson=new Gson();
		out.print(gson.toJson(result));
		out.flush();
		out.close();
		return null;
	}

	private Map<String, Object> result = new HashMap<String, Object>();
	private UserInfo userInfo;
	private List<UserInfo> userInfos;
	private Page<UserInfo> page;
	private String pageNo="1";
	

	

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public Page<UserInfo> getPage() {
		return page;
	}

	public void setPage(Page<UserInfo> page) {
		this.page = page;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
