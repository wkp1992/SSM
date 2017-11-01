$(function(){
	
	$.messager.show({
		showType :  'slide',//定义将如何显示该消息
		showSpeed : 600,//定义窗口显示的过度时间
		width : 350,
		height : 180,
		title : '提示',
		msg : '我在测试messager.show',
		timeout : 5000
	});
	
	$.messager.alert({
		title : '提示',
		msg : '我在测试messager.alert',
		icon : 'warning',
		fn : function(){//关闭窗口时触发该函数
			alert('关闭窗口时触发该函数');
		}
	});
	
	$.messager.confirm({
		title : '提示',
		msg : '我在测试messager.confirm',
		fn : function(b){
			if(b){
				alert("确定");
			}else{
				alert("取消");
			}
		}
	});
	
	$.messager.prompt({
		title : '提示',
		msg : '请输入信息',
		fn : function(val){
			alert(val);
		}
	});
	
});