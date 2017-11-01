$(function(){
	
	//初始化权限
	$("#tree-perm").tree({
		url : contextPath + "/login/permissions",
		animate : true,
		lines : true,
		onClick : function(node){
			//获取附加参数rul
			var url = node.attributes.url;
			if(url != null && url != ''){
				//添加或更新选项卡
				tabsFun(node.id,node.text,url);
			}
		}
	});
	
});

function tabsFun(id,title,url){
	var content = '<iframe src=' + contextPath + url + ' frameborder="0" scrolling="auto" width="100%" height="100%"></iframe>';
	//判断选项卡是否存在，通过title属性判断选项卡是否存在
	var exists = $("#index-tabs").tabs("exists",title);
	if(exists){//存在
		//选中选项卡面板
		$("#index-tabs").tabs("select",title);
		//获取选项卡面板
		var tab = $("#index-tabs").tabs("getTab",title);
		//更新选项卡面板
		$("#index-tabs").tabs("update",{
			tab : tab,
			options : {
				id : id,
				title : title,
				content : content,
				closable : true
			}
		});
	}else{//不存在
		//添加选项卡面板
		$("#index-tabs").tabs("add",{
			id : id,
			title : title,
			content : content,
			closable : true
		});
	}
}
