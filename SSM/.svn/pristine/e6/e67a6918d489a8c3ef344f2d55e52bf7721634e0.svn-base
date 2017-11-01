package com.etoak.modules.user.service;

import java.util.List;
import java.util.Map;

import com.etoak.common.utils.TreeNode;
import com.etoak.modules.user.bean.User;

public interface UserService {
	
	public int add(User user);
	
	/**
	 * 用户分页信息
	 * @param page 当前页
	 * @param rows 每页记录数
	 * @param user 用户信息
	 */
	public Map<String,Object> findInfoByUserPage(
			Integer page,Integer rows,User user);
	
	/**
	 * 通过主键ID查找用户信息
	 * @param id
	 * @return
	 */
	public User findUserByPrimaryKeyId(String id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 获取角色，用树形结构展示
	 * @param userId 用户ID
	 */
	public List<TreeNode> getRoleTree(String userId);
	
	/**
	 * 用户分配角色
	 * @param userId 用户ID
	 * @param roles 角色ID
	 */
	public void allotRole(String userId,List<String> roles);
}
