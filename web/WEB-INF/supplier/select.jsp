<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp"%>
<html>
<head>

<title></title>
<style type="text/css">
.searchbox{
	margin:-3
}
</style>

<script type="text/javascript">
	$(function(){
		// 返回ifram 页面窗体对象（window)
		var win = parent.$("iframe[title='商品采购'").get(0).contentWindow;
			$('#dg').datagrid({    
			    <%--url:'${proPath}/datagrid_data1.json', --%>
				url: '${proPath}/supplier/selectPageListDyc.action',
			    fitColumns:true,
				nowrapL:true,
			    idField: 'supId',
				rownumbers:true,
			    pagination:true,
			    pageSize:10,
			    pageList:[3,5,10,20],
			    
			     queryParams: {
					supName: '%%',
					supAddress: '%%'
				},

				toolbar: [{
					iconCls: 'icon-ok',
					text:'选择供应商',
					handler: function(){
						var row = $("#dg").datagrid("getSelected");
						// alert(row.supId);
						win.$("#ff").form('load',{
							supId:row.supId,
							supName:row.supName
						});
						parent.$('#win').window("close");
					}
				},'-',{
					text:"名称： <input type='text' id='supName' name='supName'/>",
				},'-',{
					text:"地址： <input type='text' id='supAddress' name='supAddress'/>",
				}],
			       
				columns : [ [{
					checkbox:true,
				}, {
					field : 'supId',
					title : '供应商编号',
					width : 100
				}, {
					field : 'supName',
					title : '供应商名称',
					width : 100
				},{
					field : 'supLinkman',
					title : '供应商联系人',
					width : 100
				},{
					field : 'supPhone',
					title : '供应商联系电话',
					width : 100,
					align : 'right'
				},{
					field : 'supAddress',
					title : '供应商地址',
					width : 100,
					align : 'right'
				},{
					field : 'supPay',
					title : '期初应付（元）',
					width : 100,
					align : 'right'
				},{
					field : 'supType',
					title : '供应商类型',
					width : 100,
					align : 'right'
				} ] ]
		});
		
		$('#supAddress').searchbox({
			searcher:function(value,name){
				// alert("supAddress:"+value);
				// alert("supName:"+$('#supName').val());
				$('#dg').datagrid('load',{
					supName: '%'+$('#supName').val()+'%',
					supAddress:'%'+value+'%'
				});
			},
			prompt:''
		});


	});
</script>
</head>

<body>
	<table id="dg"></table>
</body>
</html>