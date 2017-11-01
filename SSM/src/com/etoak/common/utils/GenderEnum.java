package com.etoak.common.utils;

public enum GenderEnum {
	
	GENDER0("Å®","0"),
	GENDER1("ÄÐ","1");
	
	
	private String code;
	private String value;
	
	private GenderEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static void main(String[] args) {
		/*GenderEnum var0 = GenderEnum.GENDER0;
		System.out.println(var0.getCode() + "|" + var0.getValue());*/
		
		GenderEnum[] genderEnum = GenderEnum.values();
		for(GenderEnum ge : genderEnum){
			System.out.println(ge.code + "|" + ge.value);
		}
	}
	
}
