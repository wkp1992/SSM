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
 * �û�ҵ��
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
	 * ͨ��username��ȡ�û���Ϣ
	 * @param username �û���
	 */
	@Override
	public User getUsername(String username) {
		User user = userMapper.getUsername(username);
		return user;
	}

	/**
	 * ͨ���û�ID���ҽ�ɫ
	 * @param userId �û�ID
	 */
	@Override
	public List<String> findRoleByUserId(String userId) {
		List<String> list = userMapper.findRoleByUserId(userId);
		return list;
	}

	/**
	 * ͨ����ɫID������Ϣ
	 * @param roleIds
	 * @return
	 */
	@Override
	public List<Role> findInfoByRoleIds(List<String> roleIds) {
		List<Role> list= roleMapper.findInfoByRoleIds(roleIds);
		return list;
	}

	/**
	 * ͨ��ID��ȡ����Ȩ��
	 * @param id
	 */
	@Override
	public List<Permissions> getPermAll(String id) {
		List<Permissions> list = permissionsMapper.getPermAll(id);
		return list;
	}

	/**
	 * ͨ����ɫID��ȡָ��Ȩ��
	 */
	@Override
	public List<Permissions> getPermByRoleIds(Map<String, Object> map) {
		List<Permissions> list = 
				permissionsMapper.getPermByRoleIds(map);
		return list;
	}

}
