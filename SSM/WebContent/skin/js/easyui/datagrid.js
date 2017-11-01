$(function(){
	//表格
	$("#et").datagrid({
		//通过远程地址加载数据信息
		url : contextPath + "/tree/getAllPage.do",
		//如果为true，则只允许选择一行
		singleSelect : true,
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
		pageSize : 2,
		//选择展示的每页记录数
		pageList :[2,10,20,30,50,100],
		//显示内容信息
		columns : [[
		            {field:'id',title:'主键ID',width:100,align:'center',checkbox:true},
		            {field:'pid',title:'父ID',width:100,align:'center'},
		            {field:'name',title:'权限名称',width:100,align:'center'},
		            {field:'status',title:'是否冻结',width:100,align:'center',
		            	formatter:function(value,row,index){
		            		/**
		            		 * value:表示当前记录列的值
		            		 * row:表示当前记录这一行的对象
		            		 * index:表示当前记录下标(行数起始值0)
		            		 * */
		            		//return value + "|" + row.id + "|" + index;
		            		if(value == '1'){
		            			return "启用";
		            		}else if(value == '0'){
		            			return "禁用";
		            		}
		            		return value;
		            	} }
		          ]]
	});
	
});