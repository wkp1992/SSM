<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<form id="user-form" method="post">
		
		<input type="hidden" name="id" value="${u.id }" />
	
		<table style="margin: 0 auto;" cellpadding="4" cellspacing="4">
			<tr>
				<td>用户名</td>
				<td>
					<input id="username" name="username" 
						   class="easyui-textbox"
						   data-options="required:true,width:180" value="${u.username }"/>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>
					<input id="password" name="password"
						   class="easyui-textbox"
						   data-options="required:true,width:180,type:'passowrd'"
						   value="${u.password }"/>
				</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td>
					<input id="nickname" name="nickname"
						   class="easyui-textbox"
						   data-options="required:true,width:180"
						   value="${u.nickname }"/>
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input id="email" name="email"
						   class="easyui-textbox"
						   data-options="required:true,width:180,validType:'email'"
						   value="${u.email }"/>
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>
					<input id="tel" name="tel"
						   class="easyui-numberbox"
						   data-options="required:true,width:180"
						   value="${u.tel }"/>
				</td>
			</tr>
			<tr>
				<td>是否冻结</td>
				<td>
					<input id="status" name="status"  value="${u.status }"
						   class="easyui-combobox"
						   data-options="required:true,width:180,panelHeight:50,
						   	   valueField:'value',textField:'label',
						   	   data: [{
									label: '启用',
									value: '1'
								},{
									label: '禁用',
									value: '0'
								}]" />
				</td>
			</tr>
		</table>
	</form>
</body>
