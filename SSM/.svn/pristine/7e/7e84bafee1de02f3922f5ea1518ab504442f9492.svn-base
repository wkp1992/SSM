package com.etoak.modules.system.service;

import java.util.List;
import java.util.Map;

import com.etoak.modules.permissions.bean.Permissions;
import com.etoak.modules.role.bean.Role;
import com.etoak.modules.user.bean.User;

public interface LoginService {
	
	/**
	 * 通过username获取用户信息
	 * @param username 用户名
	 */
	public User getUsername(String username);
	
	/**
	 * 通过用户ID查找角色
	 * @param userId 用户ID
	 */
	public List<String> findRoleByUserId(String userId);
	
	/**
	 * 通过角色ID查找信息
	 * @param roleIds
	 * @return
	 */
	public List<Role> findInfoByRoleIds(List<String> roleIds);
	
	/**
	 * 通过ID获取所有权限
	 * @param id
	 */
	public List<Permissions> getPermAll(String id);
	
	/**
	 * 通过角色ID获取指定权限
	 */
	public List<Permissions> 
	getPermByRoleIds(Map<String,Object> map);

}
