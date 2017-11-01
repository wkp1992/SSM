package com.etoak.modules.user.service;

import java.util.List;
import java.util.Map;

import com.etoak.common.utils.TreeNode;
import com.etoak.modules.user.bean.User;

public interface UserService {
	
	public int add(User user);
	
	/**
	 * �û���ҳ��Ϣ
	 * @param page ��ǰҳ
	 * @param rows ÿҳ��¼��
	 * @param user �û���Ϣ
	 */
	public Map<String,Object> findInfoByUserPage(
			Integer page,Integer rows,User user);
	
	/**
	 * ͨ������ID�����û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserByPrimaryKeyId(String id);
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * ��ȡ��ɫ�������νṹչʾ
	 * @param userId �û�ID
	 */
	public List<TreeNode> getRoleTree(String userId);
	
	/**
	 * �û������ɫ
	 * @param userId �û�ID
	 * @param roles ��ɫID
	 */
	public void allotRole(String userId,List<String> roles);
}
