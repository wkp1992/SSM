<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/include.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/skin/js/modules/user/user.js"></script>
</head>
<body>

	<!-- 用户列表 -->
	<table id="user-datagrid"></table>
	
	<!-- 用户列表操作 -->
	<div id="user-datagrid-toolbar" style="overflow: hidden;">
		<div style="float: right;">
			<!-- 查询 -->
			<a href="javascript:void(0);" 
			   class="easyui-linkbutton"
			   data-options="iconCls:'icon-search',plain:true"
			   onclick="obj.query();">
				查询
			</a>
			<!-- 新增 -->
			<a href="javascript:void(0);" 
			   class="easyui-linkbutton"
			   data-options="iconCls:'icon-add',plain:true"
			   onclick="obj.add();">
				新增
			</a>
			<!-- 修改 -->
			<a href="javascript:void(0);" 
			   class="easyui-linkbutton"
			   data-options="iconCls:'icon-edit',plain:true"
			   onclick="obj.update();">
				修改
			</a>
			<!-- 删除 -->
			<a href="javascript:void(0);" 
			   class="easyui-linkbutton"
			   data-options="iconCls:'icon-remove',plain:true"
			   onclick="obj.del();">
				删除
			</a>
			<!-- 用户分配角色 -->
			<a href="javascript:void(0);" 
			   class="easyui-linkbutton"
			   data-options="iconCls:'icon-edit',plain:true"
			   onclick="obj.allotRole();">
				分配角色
			</a>
		</div>
	</div>

</body>
</html>