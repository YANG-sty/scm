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
				url: '${proPath}/goods/selectPageListDyc.action',
			    fitColumns:true,
				nowrapL:true,
			    idField: 'goodsId',
				rownumbers:true,
				singleSelect: true,
			    pagination:true,
			    pageSize:10,
			    pageList:[3,5,10,20],
			    
			     queryParams: {
					supName: '%%',
					supAddress: '%%'
				},

				toolbar: [{
					iconCls: 'icon-save',
					text:'保存',
					handler: function(){
						var row = $("#dg").datagrid("getSelected");
						if(row == null){
							alert("请选择需要采购的商品！！！")
							return false;
						}
						// alert(row.goodsId);
						win.$("#dg").datagrid('appendRow',{
							goodsId: row.goodsId,
							goodsName: row.goodsName,
							goodsUnit:row.goodsUnit,
							goodsType:row.goodsType,
							goodsColor:row.goodsColor,
							bodAmount:$("#bodAmount").val(),
							bodBuyPrice:$("#bodBuyPrice").val(),
							bodTotalPrice:$("#bodBuyPrice").val()*$("#bodAmount").val(),
							bodImeiList:$("#bodImeiList").val()
						});
						location.reload();
					}
				},'-',{
					text:"名称： <input type='text' id='goodsName' name='goodsName'/>",
				}],
			       
				columns : [ [{
					checkbox:true,
				}, {
					field : 'goodsId',
					title : '商品编号'
				}, {
					field : 'goodsName',
					title : '商品名称',
					width : 100
				}, {
					field : 'goodsUnit',
					title : '单位',
					width : 100
				}, {
					field : 'goodsType',
					title : '型号',
					width : 100
				}, {
					field : 'goodsColor',
					title : '颜色',
					width : 100,
					formatter: function (value, row, index) {
						// alert(value);
						<c:forEach items="${applicationScope.sysParam.goodsColor}" var="goodsColor">
						if ("${goodsColor.key}" == value) {
							<%--alert(value);--%>
							<%--alert("${goodsColor.key}");--%>
							return "${goodsColor.value}";
						}
						</c:forEach>
					}
				} ] ]
		});
		
		$('#goodsName').searchbox({
			searcher:function(value,name){
				$('#dg').datagrid('load',{
					goodsName:'%'+value+'%'
				});
			},
			prompt:''
		});


	});
</script>
</head>

<body>
	<table id="dg"></table>

	<form  style="padding:5px;margin:0px;background:#eee;"  action="#">
		采购数量：<input type="text" id='bodAmount' name='bodAmount' class="easyui-numberbox" value="" data-options="min:1,max:1000000000">
		价格：<input type="text" id='bodBuyPrice' name='bodBuyPrice' class="easyui-numberbox"  value="" data-options="min:0,precision:2">
		串号：<textarea  id='bodImeiList' name='bodImeiList'></textarea>

	</form>
</body>
</html>