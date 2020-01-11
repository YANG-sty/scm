<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp" %>
<html>
<head>


<title> </title>

<script type="text/javascript">
	$(function(){

        $('#dg').datagrid({
            url: '${proPath}/goods/selectPageListDyc.action',
            fitColumns:true,
            nowrapL:true,
            idField: 'goodsId',
            rownumbers:true,
            pagination:true,
            pageSize:10,
            pageList:[3,5,10,20],

            queryParams: {
                goodsId: '%%',
                goodsName: '%%'
            },

            toolbar: [{
                iconCls: 'icon-add',
                text:'新增',
                handler: function(){
                    // alert('新增按钮');
                    parent.$('#win').window({
                        title :'添加商品',
                        width:600,
                        height:400,
                        modal:true,
                        content:"<iframe src='${proPath}/base/goURL/goods/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    // alert('修改按钮');
                    //判断是否选中了一行，并且只能选中一行
                    var array = $('#dg').datagrid("getSelections");
                    if(array.length != 1){
                        alert("您选择了多条记录！！！！");
                        return false;
                    }
                    parent.$('#win').window({
                        title : '修改商品',
                        width : 600,
                        height: 400,
                        modal: true,
                        content:"<iframe src='${proPath}/base/goURL/goods/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                text:'删除',
                handler: function(){
                    // alert('删除按钮');
                    var array = $('#dg').datagrid("getSelections");
                    if(array.length>0){
                        // alert("选中");
                        //定义数组，通过下边的用来存储选中记录的ID
                        var ids = new Array();
                        for(i=0; i<array.length; i++){
                            ids[i] = array[i].goodsId;
                            // alert(ids[i]);
                        }
                        // alert("ids: "+ids);
                        //锁定整个页面，前面加 parent
                        parent.$.messager.confirm('删除对话框', '确定要删除数据！！！', function (r) {
                            if(r){
                                // alert(r);
                                $.ajax({
                                    url : "${proPath}/goods/deleteList.action",
                                    type: "POST",
                                    //设置为传统的方式传递参数
                                    traditional: true,
                                    data:{ids:ids},
                                    success: function (html) {
                                        if(html>0){
                                            alert("删除成功，删除了 " + html + " 条数据！！！");
                                        }else {
                                            alert("删除失败！！！！！");
                                        }
                                        //重新刷新页面
                                        $("#dg").datagrid("reload");
                                        //删除所有勾选的行
                                        $("#dg").datagrid("clearSelections");
                                    },
                                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                                        $.messager.alert('删除错误！！！！','请联系管理员！！！！','error');
                                    },
                                    dataType: 'json'
                                });
                            }
                        });
                    }
                }
            },'-',{
                text:"商品编号： <input type='text' id='goodsId' name='goodsId'/>",
            },'-',{
                text:"商品名称： <input type='text' id='goodsName' name='goodsName'/>",
            },'-',{
                text:"商品类型： <input type='text' id='goodsType' name='goodsType'/>",
            }],
            columns: [[
                {checkbox:true},
                {field: 'goodsId', title: '商品编号', width: 100},
                {field: 'goodsName', title: '商品名称', width: 100},
                {field: 'goodsUnit', title: '商品单位', width: 100},
                {field: 'goodsType', title: '商品类型', width: 100},
                {field: 'goodsColor', title: '商品颜色', width: 100,
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
                },
                {field: 'goodsStore', title: '商品仓库', width: 100,
                    formatter: function (value, row, index) {
                        <c:forEach items="${applicationScope.sysParam.shId}" var="shId">
                        if ("${shId.key}" == value) {
                            return "${shId.value}";
                        }
                        </c:forEach>
                    }
                },
                {field: 'goodsLimit', title: '商品下限', width: 100},
                {field: 'goodsCommission', title: '提成', width: 100},
                {field: 'goodsProducer', title: '生产厂家', width: 100},
                {field: 'goodsRemark', title: '备注', width: 100},
                {field: 'goodsSelPrice', title: '售价', width: 100},
                {field: 'goodsBuyPrice', title: '进价', width: 100, align: 'right'}
            ]]
        });
        $('#goodsType').searchbox({
            searcher:function(value,name){
                $('#dg').datagrid('load',{
                    goodsId: '%'+$('#goodsId').val()+'%',
                    goodsName: '%'+$('#goodsName').val()+'%',
                    goodsType:'%'+value+'%'
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