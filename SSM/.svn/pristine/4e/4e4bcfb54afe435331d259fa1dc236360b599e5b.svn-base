package com.etoak.modules.user.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.etoak.common.utils.TreeNode;
import com.etoak.modules.role.bean.Role;
import com.etoak.modules.role.mapper.RoleMapper;
import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.mapper.UserMapper;
import com.etoak.modules.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int add(User user) {
		User u = userMapper.getUsername(user.getUsername());
		if(u != null){
			throw new RuntimeException(user.getUsername() + "用户已经存在！");
		}
		
		int result = userMapper.add(user);
		return result;
	}

	/**
	 * 用户分页信息
	 * @param page 当前页
	 * @param rows 每页记录数
	 * @param user 用户信息
	 */
	@Override
	public Map<String, Object> findInfoByUserPage(Integer page, Integer rows, User user) {
		//分页  page 当前页 rows 每页记录数
		PageHelper.startPage(page,rows);
		//获取用户信息
		List<User> list = userMapper.selectAll();
		//获取分页信息
		PageInfo<User> pi = new PageInfo<>(list);
		
		//返回值信息
		Map<String,Object> result = new HashMap<>();
		//用户查询总数量
		result.put("total", pi.getTotal());
		//用户查询结果集
		result.put("rows", list);
		
		return result;
	}

	/**
	 * 通过主键ID查找用户信息
	 * @param id
	 * @return
	 */
	@Override
	public User findUserByPrimaryKeyId(String id) {
		User user = userMapper.findUserByPrimaryKeyId(id);
		return user;
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int update(User user){
		int result = userMapper.update(user);
		return result;
	}

	/**
	 * 获取角色，用树形结构展示
	 * @param userId 用户ID
	 */
	@Override
	public List<TreeNode> getRoleTree(String userId) {
		
		List<TreeNode> list = Collections.EMPTY_LIST;
		
		//获取状态为1的角色 1:表示启用
		List<Role> roles = roleMapper.getRoleTreeStatus("1");
		if(roles != null && roles.size() > 0){
			//获取用户有哪些角色
			List<String> userRoles = 
					userMapper.findRoleByUserId(userId);
			
			list = new ArrayList<>();
			TreeNode tree = null;
			
			for(Role role : roles){
				tree = new TreeNode();
				
				tree.setId(role.getId());
				tree.setText(role.getName());
				//当前角色role.getId()是否包含在userRoles里，包含返回true，不包含返回false
				tree.setChecked(userRoles.contains(role.getId()));
				
				list.add(tree);
			}
		}
		
		return list;
	}

	/**
	 * 用户分配角色
	 * @param userId 用户ID
	 * @param roles 角色ID
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void allotRole(String userId, List<String> roles) {
		//通过用户ID删除角色
		userMapper.delRolesByUserId(userId);
		
		if(roles != null && roles.size() > 0){
			Map<String,Object> params = new HashMap<>();
			params.put("userId", userId);
			params.put("list", roles);
			//用户分配角色
			int result = userMapper.addUserRoles(params);
			if(result <= 0){
				throw new RuntimeException("用户分配角色失败！");
			}
		}
	}

}
