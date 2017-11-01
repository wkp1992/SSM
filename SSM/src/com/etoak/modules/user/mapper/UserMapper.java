package com.etoak.modules.user.mapper;

import java.util.List;
import java.util.Map;

import com.etoak.modules.user.bean.User;

public interface UserMapper {
	
	public int add(User user);
	
	public List<User> selectAll();
	
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
	 * 通过用户ID删除角色
	 * @param userId 用户ID
	 */
	public int delRolesByUserId(String userId);
	
	/**
	 * 用户分配角色
	 * @param userId 用户ID
	 * @param roles 角色ID
	 */
	public int addUserRoles(Map<String,Object> map);

}
