package com.etoak.modules.easyui.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.common.utils.GenderEnum;

@Controller
@RequestMapping("/combobox")
public class ComboboxController {
	
	@RequestMapping("/getGender")
	@ResponseBody
	public List<Map<String,Object>> getGender(){
		
		List<Map<String,Object>> list = Collections.EMPTY_LIST;
		
		GenderEnum[] genderEnum = GenderEnum.values();
		if(genderEnum.length > 0){
			list = new ArrayList<>();
			Map<String,Object> map = null;
			for(GenderEnum ge : genderEnum){
				map = new HashMap<>();
				map.put("label", ge.getCode());
				map.put("value", ge.getValue());
				list.add(map);
			}
		}
		
		return list;
	}

}
