package com.etoak.modules.system.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.bcel.classfile.ParameterAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.etoak.common.utils.JsonResult;
import com.etoak.common.utils.TreeNode;
import com.etoak.modules.permissions.bean.Permissions;
import com.etoak.modules.role.bean.Role;
import com.etoak.modules.system.service.LoginService;
import com.etoak.modules.user.bean.User;

/**
 * 登录操作
 */
@SessionAttributes(value={"user"})
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult login(String username,
							String password,
							Model m){
		
		//通过username查询用户信息
		User user = loginService.getUsername(username);
		//判断用户是否存在
		if(user == null){
			return new JsonResult(-1,"当前用户" + username + "不存在！"); 
		}
		//判断密码是否正确
		String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
		if(!pwd.equals(user.getPassword())){
			return new JsonResult(-2,"密码错误！");
		}
		//判断用户是否被冻结
		if(0 == user.getStatus()){
			return new JsonResult(-3,"当前用户" + username + "已被冻结！");
		}
		
		//清空密码
		user.setPassword(null);
		
		//通过用户ID获取角色
		List<String> roleIds = 
				loginService.findRoleByUserId(user.getId());
		
		user.setRoleIds(roleIds);
		
		m.addAttribute("user", user);
		
		return new JsonResult(200,null);
	}
	
	/**
	 * 获取权限
	 * @param id 权限id 初始化默认为0
	 */
	@RequestMapping("/permissions")
	@ResponseBody
	public List<TreeNode> permissions(
			@RequestParam(value="id",defaultValue="0") String id,
			ModelMap m){
		
		List<TreeNode> trees = Collections.EMPTY_LIST;
		
		//获取session中用户信息
		User user = (User)m.get("user");
		//获取用户拥有的角色
		List<String> roleIds = user.getRoleIds();
		//通过角色ID查找信息
		List<Role> listRole = 
				loginService.findInfoByRoleIds(roleIds);
		if(listRole != null && listRole.size() > 0){
			//判断当前用户中是否存在管理员（ETOAK）角色
			Role r = new Role();
			r.setName("ETOAK");
			if(listRole.contains(r)){//true为管理员
				//管理员查找所有权限
				List<Permissions> list = loginService.getPermAll(id);
				trees = getPermTree(list);
			}else{
				Map<String,Object> params = new HashMap<>();
				params.put("list", roleIds);
				params.put("id", id);
				List<Permissions> list = 
						loginService.getPermByRoleIds(params);
				trees = getPermTree(list);
			}
		}
		
		return trees;
	}
	
	
	private List<TreeNode> getPermTree(List<Permissions> list){
		List<TreeNode> trees = Collections.EMPTY_LIST;
		if(list != null && list.size() > 0){
			trees = new ArrayList<>();
			TreeNode tree = null;
			for(Permissions p : list){
				tree = new TreeNode();
				tree.setId(p.getId());
				tree.setText(p.getName());
				tree.setState(p.getIsLeaf() == 0 ? "closed" : "open");
				Map<String,Object> attributes = new HashMap<>();
				attributes.put("pid", p.getPid());
				attributes.put("url", p.getUrl());
				tree.setAttributes(attributes);
				trees.add(tree);
			}
		}
		return trees;
	}
	
	/**
	 * 退出
	 * @param session
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(SessionStatus session){
		//清空session
		session.setComplete();
		return "redirect:/";
	}
	
	/**
	 * 跳转主页
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
}
