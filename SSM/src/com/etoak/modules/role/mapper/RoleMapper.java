package com.etoak.modules.role.mapper;

import java.util.List;

import com.etoak.modules.role.bean.Role;

public interface RoleMapper {
	
	/**
	 * ͨ����ɫID������Ϣ
	 * @param roleIds
	 * @return
	 */
	public List<Role> findInfoByRoleIds(List<String> roleIds);
	
	/**
	 * ��ȡ��ɫ
	 * @param status ״̬  0����ʾ���� 1����ʾ����
	 */
	public List<Role> getRoleTreeStatus(String status);

}
