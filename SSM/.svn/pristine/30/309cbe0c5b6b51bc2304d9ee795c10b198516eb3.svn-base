$(function(){
	//初始化用户列表
	$("#user-datagrid").datagrid({
		//通过远程地址加载数据信息
		url : contextPath + "/user/list",
		//工具栏
		toolbar : "#user-datagrid-toolbar",
		//如果为true，则只允许选择一行
		singleSelect : false,
		//是否显示斑马线
		striped : true,
		//在从远程站点加载数据的时候显示提示消息。
		loadMsg : '正在玩命加载，请稍等...',
		//真正的自动展开/收缩列的大小，以适应网格的宽度，防止水平滚动
		fitColumns : true,
		//自适应
		fit : true,
		//是否显示行号
		rownumbers : true,
		//是否显示底部分页工具栏
		pagination : true,
		//在设置分页属性的时候初始化页码。
		pageNumber : 1,
		//每页记录数
		pageSize : 50,
		//选择展示的每页记录数
		pageList :[50,100],
		//显示内容信息
		columns : [[
		            {field:'id',title:'主键ID',width:80,align:'center',checkbox:true},
		            {field:'username',title:'用户名',width:60,align:'center'},
		            {field:'nickname',title:'昵称',width:40,align:'center'},
		            {field:'email',title:'邮箱',width:60,align:'center'},
		            {field:'tel',title:'电话',width:30,align:'center'},
		            {field:'status',title:'是否被冻结',width:30,align:'center',
		            	formatter: function(value,row,index){
		            		if(value == '1'){
		            			return "否";
		            		}else if (value == '0'){
		            			return '是';
		            		}
		            		return value;
		            	}
		            },
		            {field:'createTime',title:'创建时间',width:60,align:'center'}
		          ]]
	});
	
	
});

//用户操作
var obj = {
	query : function(){
		dialog("query-dialog").dialog({
			title : '用户查询',
			width : 450,
			height : 300,
			href : contextPath + '/user/query',
			buttons : [
			           {
			        	   text : "查询",
			        	   iconCls : 'icon-ok',
			        	   handler : function(){
			        		   $("#user-datagrid").datagrid("load",{
			        			   
			        		   });
			        	   }
			           },
			           {
			        	   text : "重置",
			        	   iconCls : 'icon-cancel',
			        	   handler : function(){
			        		   
			        	   }
			           }
			          ]
		});
	},
	add : function(){
		dialog("add-dialog").dialog({
			title : '用户新增',
			width : 450,
			height : 300,
			href : contextPath + '/user/add-update',
			buttons : [
			           {
			        	   text : "保存",
			        	   iconCls : 'icon-ok',
			        	   handler : function(){
			        			$("#user-form").form("submit",{
			        				 url : contextPath + "/user/add?d=" + Math.random(),
			        				 onSubmit : function(param){
			        					 return $("#user-form").form('validate');
			        				 },
			        				 success : function(data){
			        					 var json = $.parseJSON(data);
			        					 
			        					 $.messager.show({
			        						 title : '提示',
			        						 msg : json.msg,
			        						 width : 350,
			        						 height : 150
			        					 });
			        					 
			        					 if(json.code == 200){
			        						 $("#user-datagrid").datagrid("reload");
			        						 $("#add-dialog").dialog("close");
			        						 $("#add-dialog").dialog("clear");
			        					 }
			        				 }
			        			});
			        	   }
			           },
			           {
			        	   text : "重置",
			        	   iconCls : 'icon-cancel',
			        	   handler : function(){
			        		   $("#user-form").form("clear");
			        	   }
			           }
			          ]
		});
	},
	update : function(){
		var rows = $("#user-datagrid").datagrid("getSelections");
		//没有选择数据
		if(rows.length == 0){
			$.messager.show({
				 title : '提示',
				 msg : '请选择一条记录修改！',
				 width : 350,
				 height : 150
			 });
			return;
		}
		//选择多条数据
		if(rows.length > 1){
			$.messager.show({
				 title : '提示',
				 msg : '只能选择一条记录修改！',
				 width : 350,
				 height : 150
			 });
			return;
		}
		
		//获取数组中第一条记录
		var row = rows[0];
		
		dialog("update-dialog").dialog({
			title : '用户修改',
			width : 450,
			height : 300,
			href : contextPath + '/user/add-update?userId=' + row.id + "&d=" + Math.random(),
			buttons : [
			           {
			        	   text : "修改",
			        	   iconCls : 'icon-ok',
			        	   handler : function(){
			        			$("#user-form").form("submit",{
			        				 url : contextPath + "/user/update",
			        				 onSubmit : function(param){
			        					 return $("#user-form").form('validate');
			        				 },
			        				 success : function(data){
			        					 var json = $.parseJSON(data);
			        					 
			        					 $.messager.show({
			        						 title : '提示',
			        						 msg : json.msg,
			        						 width : 350,
			        						 height : 150
			        					 });
			        					 
			        					 if(json.code == 200){
			        						 $("#user-datagrid").datagrid("reload");
			        						 $("#update-dialog").dialog("close");
			        						 $("#update-dialog").dialog("clear");
			        					 }
			        				 }
			        			});
			        	   }
			           },
			           {
			        	   text : "重置",
			        	   iconCls : 'icon-cancel',
			        	   handler : function(){
			        		   $("#user-form").form("clear");
			        	   }
			           }
			          ]
		});
	},
	del : function(){
		var rows = $("#user-datagrid").datagrid("getSelections");
		//没有选择数据
		if(rows.length == 0){
			$.messager.show({
				 title : '提示',
				 msg : '请选择一条记录修改！',
				 width : 350,
				 height : 150
			 });
			return;
		}
		
		$.messager.confirm('提示', '您想要删除吗？', function(r){
			if (r){
			   var ids = [];
			   for(var i = 0;i < rows.length;i++){
				   var row = rows[i];
				   ids.push(row.id);
			   }
			   
			   //JSON.stringify(ids);
			   //ids.join("!");//[1,2,3,4] 1!2!3!4
			   
			   $.ajax({
				   url : contextPath + "/user/del",
				   contentType : "application/json; charset=UTF-8",
				   //data : {ids : ids.join("!")},
				   data : JSON.stringify(ids),
				   type : "post",
				   dataType : "json",
				   success : function(data){
					   //返回信息
				   }
			   });
			   
			}
		});
	},
	allotRole : function(){
		var rows = $("#user-datagrid").datagrid("getSelections");
		//没有选择数据
		if(rows.length == 0){
			$.messager.show({
				 title : '提示',
				 msg : '请选择一个用户分配角色！',
				 width : 350,
				 height : 150
			 });
			return;
		}
		//只能选择一条记录
		if(rows.length > 1){
			$.messager.show({
				 title : '提示',
				 msg : '只能选择一个用户分配角色！',
				 width : 350,
				 height : 150
			 });
			return;
		}
		
		var row = rows[0];
		
		dialog("allotRole").dialog({
			title : row.username + "用户分配角色",
			width : 450,
			height : 300,
			href : contextPath + "/user/getRole?userId=" + row.id,
			buttons : [
			           {
			        	   text : "分配角色",
			        	   iconCls : "icon-ok",
			        	   handler : function(){
			        		  //获取选中的角色
			        		  var trees = $("#userRoleTree").tree("getChecked");
			        		  //将一个数组中的元素转换到另一个数组中
			        		  var data = $.map(trees,function(tree){
			        			  return tree.id;
			        		  });
			        		  //发送请求
			        		  $.ajax({
			        			  url : contextPath + "/user/allotRole/" + row.id,
			        			  contentType : "application/json; charset=UTF-8",
			        			  data : JSON.stringify(data),
			        			  type : "post",
			        			  //jsonp跨域
			        			  dataType : "json",
			        			  success : function(data){
			        				  $.messager.show({
			        						 title : '提示',
			        						 msg : data.msg,
			        						 width : 350,
			        						 height : 150
			        				  });
			        				  
			        				  if(data.code == 200){
			        					  $("#allotRole").dialog("close");
			        				  }
			        			  }
			        		  });
			        	   }
			           }
			          ]
		});
	}
};

//操作窗口
function dialog(id){
	//获取jquery对象ID
	var objId = $("#" + id);
	//判断jquery对象ID是否存在
	if(objId.size() > 0){
		return objId;
	}
	
	var html_ = '<div id="' + id + '" data-options="modal:true,closed:false,cache:false"></div>';
	objId = $(html_).appendTo(document.body);
	return objId;
}
