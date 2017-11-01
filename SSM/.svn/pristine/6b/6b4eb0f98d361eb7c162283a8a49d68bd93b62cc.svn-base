package com.etoak.modules.user.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.common.utils.JsonResult;
import com.etoak.common.utils.TreeNode;
import com.etoak.modules.jedis.JedisService;
import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JedisService jedisService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(){
		return "user/user-list";
	}
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String query(){
		return "user/user-query";
	}
	
	@RequestMapping(value="/add-update",method=RequestMethod.GET)
	public String addUpdate(String userId,Model m){
		//新增时userId为空！ 修改时userId不为空！
		if(StringUtils.isNotBlank(userId)){
			User u = userService.findUserByPrimaryKeyId(userId);
			m.addAttribute("u", u);
		}
		return "user/user-add-update";
	}
	
	/**
	 * 获取角色
	 * @param userId 用户ID
	 */
	@RequestMapping(value="/getRole",method=RequestMethod.GET)
	public String getRole(String userId,Model m){
		m.addAttribute("userId", userId);
		return "user/user-role-tree";
	}
	
	
	/**
	 * 用户分页查询列表
	 * @param page 当前页
	 * @param rows 每页记录数
	 * @param user 分页查询条件
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(Integer page,Integer rows,User user){
		return userService.findInfoByUserPage(page, rows, user);
	}

	

	/*@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(User user){
		
		user.setId(UUID.randomUUID().toString());
		user.setCreateTime(new Date());
		int result = userService.add(user);
		if(result >= 1){
			//jedisService.set(user.getUsername(), user.getPassword());
		}
		
		return "user/success";
	}*/
	
	
	/**
	 * 用户新增
	 * @param user
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(User user){
		try{
			user.setId(UUID.randomUUID().toString());
			user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
			user.setCreateTime(new Date());
			int result = userService.add(user);
			if(result >= 1){
				return new JsonResult(200,"新增" + user.getUsername() + "用户成功！");
			}
			return new JsonResult(500,"新增" + user.getUsername() + "用户失败！");
		}catch(RuntimeException e){
			return new JsonResult(500,e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(500,e.getMessage());
		}
	}
	
	/**
	 * 用户修改
	 * @param user
	 */
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public JsonResult update(User user){
		try{
			int result = userService.update(user);
			if(result >= 1){
				return new JsonResult(200,user.getUsername() + "修改信息成功！");
			}
			return new JsonResult(500,user.getUsername() + "修改信息失败！");
		}catch(Exception e){
			return new JsonResult(500,e.getMessage());
		}
	}
	
	/**
	 * 用户删除
	 * @param list
	 */
	@ResponseBody
	@RequestMapping(value="/value",method=RequestMethod.POST)
	public JsonResult del(@RequestBody List<String> list){
		return null;
	}
	
	/**
	 * 获取角色，用树形结构展示
	 * @param userId 用户ID
	 */
	@RequestMapping(value="/getRoleTree",method=RequestMethod.POST)
	@ResponseBody
	public List<TreeNode> getRoleTree(String userId){
		return userService.getRoleTree(userId);
	}
	
	/**
	 * 分配角色
	 * @param userId 用户ID
	 * @param roleIds 角色ID
	 */
	@ResponseBody
	@RequestMapping(value="/allotRole/{userId}",method=RequestMethod.POST)
	public JsonResult allotRole(
				@PathVariable String userId,
				@RequestBody List<String> roleIds){
		try{
			userService.allotRole(userId, roleIds);
			return new JsonResult(200,"用户分配角色成功！");
		}catch(RuntimeException e){
			return new JsonResult(500,e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult(500,e.getMessage());
		}
	}

}
