<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/common/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 
src="${pageContext.request.contextPath }/skin/js/easyui/textbox.js"></script>
</head>
<body>
	<%-- <input class="easyui-textbox" 
		data-options="width:180,heigth:30,prompt:'请输入信息',
		value:'et1702',type:'password',iconCls:'icon-man',
		buttonText:'textbox',onClickButton:function(){
			var v = $(this).textbox('getValue');
			alert(v);
		}"/> --%>
		
	<input id="et" />
	<input type="button" value="set" onclick="set1();">
	<input type="button" value="get" onclick="get1();">
	<input type="button" value="reset" onclick="reset1();">
	<input type="button" value="readonly" onclick="readonly1();">
</body>
</html>