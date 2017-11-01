$(function(){
	
	//登录窗口
	$("#login-dialog").dialog({
		title : "登录",
		width : 350,
		height : 150,
		modal:true,
		buttons : [
		           {
		        	   text : "保存",
		        	   iconCls : "icon-ok",
		        	   handler : function(){
		        		   //登录操作
		        		  $("#login-form").form("submit",{
		        			  url : contextPath + "/login/login.do",
		        			  onSubmit : function(param){
		        				  return $(this).form("validate");
		        			  },
		        		  	  success : function(data){
		        		  		  var json = $.parseJSON(data);
		        		  		  /**
		        		  		   * == 
		        		  		   * 不区分类型，只比较内容
		        		  		   * === 
		        		  		   * 先比较类型（类型必须一致），不一致返回false，
		        		  		   * 再比较内容是否相等，内容不相等返回false
		        		  		   */
		        		  		  if(json.code == 200){
		        		  			  window.location.href = 
		        		  				  	contextPath + "/login/index";
		        		  		  }else{
		        		  			  $.messager.show({
		        		  				  title : "提示",
		        		  				  msg : json.msg,
		        		  				  width : 300,
		        		  				  height : 150
		        		  			  });
		        		  		  }
		        		  	  }
		        		  });
		        	   }
		           },
		           {
		        	   text : "重置",
		        	   iconCls : "icon-cancel",
		        	   handler : function(){
		        		   $("#login-form").form("reset");
		        	   }
		           }
		        ]
	});
	
	//用户名
	$("#login-user").textbox({
		required : true,
		width : 180,
		iconCls : "icon-man"
	});
	
	//密码
	$("#login-pwd").textbox({
		required : true,
		width : 180,
		iconCls : "icon-lock",
		type : "password"
	});
	
});