package com.etoak.modules.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.modules.permissions.bean.Permissions;
import com.etoak.modules.permissions.mapper.PermissionsMapper;
import com.etoak.modules.role.bean.Role;
import com.etoak.modules.role.mapper.RoleMapper;
import com.etoak.modules.system.service.LoginService;
import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.mapper.UserMapper;

/**
 * 用户业务
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PermissionsMapper permissionsMapper;

	/**
	 * 通过username获取用户信息
	 * @param username 用户名
	 */
	@Override
	public User getUsername(String username) {
		User user = userMapper.getUsername(username);
		return user;
	}

	/**
	 * 通过用户ID查找角色
	 * @param userId 用户ID
	 */
	@Override
	public List<String> findRoleByUserId(String userId) {
		List<String> list = userMapper.findRoleByUserId(userId);
		return list;
	}

	/**
	 * 通过角色ID查找信息
	 * @param roleIds
	 * @return
	 */
	@Override
	public List<Role> findInfoByRoleIds(List<String> roleIds) {
		List<Role> list= roleMapper.findInfoByRoleIds(roleIds);
		return list;
	}

	/**
	 * 通过ID获取所有权限
	 * @param id
	 */
	@Override
	public List<Permissions> getPermAll(String id) {
		List<Permissions> list = permissionsMapper.getPermAll(id);
		return list;
	}

	/**
	 * 通过角色ID获取指定权限
	 */
	@Override
	public List<Permissions> getPermByRoleIds(Map<String, Object> map) {
		List<Permissions> list = 
				permissionsMapper.getPermByRoleIds(map);
		return list;
	}

}
