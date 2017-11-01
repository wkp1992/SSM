package com.etoak.modules.role.mapper;

import java.util.List;

import com.etoak.modules.role.bean.Role;

public interface RoleMapper {
	
	/**
	 * 通过角色ID查找信息
	 * @param roleIds
	 * @return
	 */
	public List<Role> findInfoByRoleIds(List<String> roleIds);
	
	/**
	 * 获取角色
	 * @param status 状态  0：表示禁用 1：表示启用
	 */
	public List<Role> getRoleTreeStatus(String status);

}
