<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
	
	var url;

	 function resetValue(){
			$("#serviceProceResult").val("");
			$("#myd").combobox("setValue","");
	 }
	
	 function saveCustomerFeedback(){
			$("#fm").form("submit",{
				url:url,
				onSubmit:function(){
					return $(this).form("validate");
				},
				success:function(result){
					var result=eval('('+result+')');
					if(result == 1){
						$.messager.alert("系统提示","处理成功");
						resetValue();
						$("#dlg").dialog("close");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","处理失败");
						return;
					}
				}
			});
		}
	 
	 
	 
	 function openCustomerFeedbackDialog(){
			var selectedRows=$("#dg").datagrid('getSelections');
			if(selectedRows.length!=1){
				$.messager.alert("系统提示","请选择一条要反馈的客户服务数据！");
				return;
			}
			var row=selectedRows[0];
			$("#dlg").dialog("open").dialog("setTitle","客户服务反馈");
			$('#fm').form('load',row);
			$("#state").val("已归档");
			url="${pageContext.request.contextPath}/customerService/update.do?id="+row.id;
		}
	 
	 function closeCustomerFeedbackDialog(){
		 $("#dlg").dialog("close");
		 resetValue();
	 }
</script>
</head>
<body style="margin:1px;">
<table id="dg" title="客户服务反馈管理" class="easyui-datagrid"
	 fitColumns="true" pagination="true" rownumbers="true"
	 url="${pageContext.request.contextPath}/customerService/list.do?state=已处理" fit="true" toolbar="#tb">
	 <thead>
	 	<tr>
	 		<th field="cb" checkbox="true" align="center"></th>
	 		<th field="id" width="50" align="center">编号</th>
	 		<th field="customer" width="100" align="center">客户</th>
	 		<th field="overView" width="200" align="center">概要</th>
	 		<th field="serveType" width="100" align="center">服务类型</th>
	 		<th field="createPeople" width="100" align="center">创建人</th>
	 		<th field="cTime" width="100" align="center">创建日期</th>
	 		<th field="state" width="100" align="center" hidden="true">客户服务状态</th>
	 		<th field="servicerequest" width="100" align="center" hidden="true">服务请求</th>
	 		<th field="assigner" width="100" align="center" hidden="true">分配人</th>
	 		<th field="aTime" width="100" align="center" hidden="true">分配日期</th>
	 		<th field="serviceProce" width="100" align="center" hidden="true">服务处理</th>
	 		<th field="serviceProcePeople" width="100" align="center" hidden="true">服务处理人</th>
	 		<th field="sTime" width="100" align="center" hidden="true">服务处理日期</th>
	 		<th field="serviceProceResult" width="100" align="center" hidden="true">服务处理结果</th>
	 		<th field="myd" width="100" align="center" hidden="true">客户满意度</th>
	 	</tr>
	 </thead>
	</table>
	
	<div id="tb">
		<div>
			<a href="javascript:openCustomerFeedbackDialog()" class="easyui-linkbutton" iconCls="icon-fwfk" plain="true">客户服务反馈</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width: 750px;height:550px;padding: 10px 20px"
	  closed="true" buttons="#dlg-buttons">
	 	<form id="fm" method="post">
	 		<table cellspacing="8px">
	 			<tr>
	 				<td>服务类型：</td>
	 				<td>
	 					<input type="text" id="serveType" name="serveType" readonly="readonly"/>
	 				</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>客户：</td>
	 				<td>
	 					<input type="text" id="customer" name="customer" readonly="readonly"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td valign="top">概要：</td>
	 				<td colspan="4">
	 					<input type="text" id="overView" name="overView" style="width:419px " class="easyui-validatebox" required="true"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td valign="top">服务请求：</td>
	 				<td colspan="4">
	 					<textarea id="servicerequest" name="servicerequest" rows="5" cols="49" readonly="readonly"></textarea>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>创建人：</td>
	 				<td><input type="text" id="createPeople" name="createPeople"  readonly="readonly" /></td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>创建时间：</td>
	 				<td><input type="text" id="cTime" name="cTime" readonly="readonly" /></td>
	 			</tr>
	 			<tr>
	 				<td>分配给：</td>
	 				<td>
	 					<input type="text" id="assigner" name="assigner" readonly="readonly" />
	 				</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>分配时间：</td>
	 				<td><input type="text" id="aTime" name="aTime" readonly="readonly" /></td>
	 			</tr>
	 			<tr>
	 				<td valign="top">服务处理：</td>
	 				<td colspan="4">
	 					<textarea id="serviceProce" name="serviceProce" rows="5" cols="49" readonly="readonly"></textarea>
	 				</td>
	 			</tr>
	 			<tr>
	 				<td>处理人：</td>
	 				<td>
	 					<input type="text" id="serviceProcePeople" name="serviceProcePeople" readonly="readonly" />
	 				</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>处理时间：</td>
	 				<td><input type="text" id="sTime" name="sTime" readonly="readonly" /></td>
	 			</tr>
	 			<tr>
	 				<td>处理结果：</td>
	 				<td>
	 					<input type="hidden" id="state" name="state"/>
	 					<input type="text" id="serviceProceResult" name="serviceProceResult"  />&nbsp;<font color="red">*</font>
	 				</td>
	 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 				<td>客户满意度：</td>
	 				<td>
	 					<select class="easyui-combobox" id="myd" name="myd" style="width: 154px;" editable="false" panelHeight="auto">
	 						<option value="">请选择...</option>
	 						<option value="☆">☆</option>
	 						<option value="☆☆">☆☆</option>
	 						<option value="☆☆☆">☆☆☆</option>
	 						<option value="☆☆☆☆">☆☆☆☆</option>
	 						<option value="☆☆☆☆☆">☆☆☆☆☆</option>
	 					</select>
	 				</td>
	 			</tr>
	 		</table>
	 	</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveCustomerFeedback()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeCustomerFeedbackDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>