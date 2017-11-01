<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/include.jsp" %>
<script type="text/javascript"
src="${pageContext.request.contextPath }/skin/js/easyui/panel.js"></script>
</head>
<body>
	<div id="et"></div>
	
	<div id="panel-tools">
		<a href="javascript:void(0);" 
		class="icon-add" 
		onclick="javascript:alert('add')"></a>
		
		<a href="javascript:void(0);" 
		class="icon-edit" 
		onclick="javascript:alert('edit')"></a>
	</div>
	
	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="open1();">open</a>
	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="close1();">close</a>
	
</body>
</html>