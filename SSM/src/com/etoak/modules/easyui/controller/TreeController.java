package com.etoak.modules.easyui.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.common.utils.TreeNode;
import com.etoak.modules.easyui.mapper.TreeMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/tree")
public class TreeController {
	
	@Autowired
	private TreeMapper treeMapper;

	/**
	 * @param id ��ʼ��tree����url���󣬵�һ��id����Ϊnull,֮��id������Ϊ��
	 * @param etoak ����etoak����
	 */
	@RequestMapping("/getNodes")
	@ResponseBody
	public List<TreeNode> getNodes(
			@RequestParam(value="id",defaultValue="0") String id,
			String etoak){
		//����tree�����
		List<TreeNode> list = Collections.EMPTY_LIST;
		
		//��ȡ�ڵ�
		List<Map<String,Object>> nodes = 
				treeMapper.findInfoByPid(id);
		//�����ڵ�
		if(nodes != null && nodes.size() > 0){
			list = new ArrayList<>();
			TreeNode tree = null;
			for(Map<String,Object> node : nodes){
				tree = new TreeNode();
				tree.setId(node.get("id").toString());
				tree.setText(node.get("name") == null ? "" : node.get("name").toString());
				
				//�жϵ�ǰ�ڵ��Ƿ����ӽڵ�
				long l = 
				treeMapper.findCountByPid(node.get("id").toString());
				String state = "open";//�ļ���
				if(l > 0){
					//l > 0��ʾ��ǰ�ڵ����ӽڵ� ����״̬Ϊopen
					state = "closed";//�ļ�
				}
				tree.setState(state);
				
				Map<String,Object> attributes = new HashMap<>();
				attributes.put("url", node.get("url").toString());
				tree.setAttributes(attributes);
				
				list.add(tree);
			}
		}
		
		return list;
	}
	
	/**
	 * @param page ��ǰҳ
	 * @param rows ÿҳ��¼��
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllPage")
	public Map<String,Object> getAllPage(
			Integer page,
			Integer rows){
		
		PageHelper.startPage(page, rows);
		List<Map<String,Object>> list = treeMapper.findAll();
		PageInfo<Map<String,Object>> pi = new PageInfo<>(list);
		
	/*	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		Map<String,Object> result = new HashMap<>();
		result.put("total", pi.getTotal());
		result.put("rows", list);
		
		return result;
	}
	
}
