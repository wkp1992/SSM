$(function(){
	
	$("#et").dialog({
		
		title : 'dialog',
		width : 500,
		height : 450,
		href : 'panel-content.jsp',
		modal: true,//遮罩层
		toolbar : '#dialog-tools',
		buttons :[
		          {
		        	  text : '保存',
		        	  iconCls : 'icon-ok',
		        	  handler : function(){
		        		  alert('保存');
		        	  }
		          },
		          {
		        	  text : '重置',
		        	  iconCls : 'icon-cancel',
		        	  handler : function(){
		        		  alert('重置');
		        	  }
		          }
		         ]
	});
	
});