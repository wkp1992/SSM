$(function(){
	
	$("#username").textbox({
		required : true,
		width : 180
	});
	
	$("#password").textbox({
		type : 'password',
		width : 180
	});
	
	$("#gender").combobox({
		url : contextPath + '/combobox/getGender.do',
		textField : 'label',
		valueField : 'value',
		panelHeight : 80,
		width : 180
	});
	
	$("#birthday").datebox({
		width : 180
	});
	
	$("#pic").filebox({
		buttonText: '选择文件', 
		width : 180
	});
	
	$("#remark").textbox({
		multiline : true,
		width : 180,
		height : 200
	});
	
});

function save(){
	$("#form").form("submit",{
		url : contextPath + "/form/form.do",
		onSubmit : function(param){
			param.etoak = 'et1702';
			//return $("#form").form('validate');
			return $(this).form('validate');
		},
		success : function(data){
			//将data返回的json字符串转成javascript对象
			var d = $.parseJSON(data);
			alert(d.success);
		}
	});
}

function reset(){
	$("#form").form("reset");
}