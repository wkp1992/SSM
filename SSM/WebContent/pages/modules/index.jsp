<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/include.jsp" %>
<script type="text/javascript" 
src="${pageContext.request.contextPath }/skin/js/modules/index.js"></script>
</head>
<body>
 	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" style="height:80px">
			<div style="float: right;line-height: 76px;margin-right: 30px;">
				<span style="margin-right: 10px;">
					<a href="${pageContext.request.contextPath }/login/logout">
						退出
					</a>
				</span>
				<span style="margin-right: 10px;">
					欢迎：${sessionScope.user.nickname }
				</span>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="导航" style="width:200px;">
			<ul id="tree-perm"></ul>
		</div>
		<div data-options="region:'center'">
			<div id="index-tabs" class="easyui-tabs" fit="true">
				
			</div>
		</div>
	</div>
</body>
</html>