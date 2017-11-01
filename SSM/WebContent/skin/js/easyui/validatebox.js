$(function(){
	
	$.extend($.fn.validatebox.defaults.rules, { 
		//value 文本框中输入的值
		//param 自定义参数
		//param[0] 下标0开始
	    minLength: {    
	        validator: function(value, param){    
	            return value.length >= param[0];    
	        },    
	        message: '长度至少{0}！'   
	    }    
	});  

	
	$("#et").validatebox({
		required : true,
		missingMessage : '请填写信息！',
		//validType : 'email',
		validType : 'minLength[5]',
		//invalidMessage : '请按照规则输入！'
		//delay : 2000
	});
	
});