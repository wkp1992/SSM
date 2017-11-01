package com.etoak.modules.http;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * �����
 */
@Controller
@RequestMapping("/http")
public class HttpController {
	
	@RequestMapping(value="/doGetParams",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> doGetParams(String username,String password){
		System.out.println("�û�����" + username);
		System.out.println("���룺" + password);
		
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		
		return map;
	}

	@RequestMapping(value="/doPostParams",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPostParams(
			String name,String cardId){
		System.out.println("������" + name);
		System.out.println("���֤��" + cardId);
		
		Map<String,Object> map = new HashMap<>();
		map.put("name", name);
		map.put("cardId", cardId);
		return map;
	}
	
	//@RequestMapping(value="/doPostJson",method=RequestMethod.POST)
	//@ResponseBody
	@RequestMapping(value="/doPostJson",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPostJson(
			@RequestBody Map<String,Object> param){
		System.out.println("������" + param.get("name"));
		System.out.println("���֤��" + param.get("cardId"));
		
		Map<String,Object> map = new HashMap<>();
		map.put("success", "success");
		map.put("msg", "�ɹ���");
		return map;
	}
	
}
