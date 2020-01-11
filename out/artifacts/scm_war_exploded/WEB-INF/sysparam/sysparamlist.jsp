<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jsp" %>
<html>
<head>


<title> </title>

<script type="text/javascript">
	$(function(){

        $('#dg').datagrid({
            url: '${proPath}/sysParam/selectPageListDyc.action',
            fitColumns:true,
            nowrapL:true,
            idField: 'sysParamId',
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
                        title :'添加系统参数',
                        width:600,
                        height:400,
                        modal:true,
                        content:"<iframe src='${proPath}/base/goURL/sysparam/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"
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
                        title : '修改系统参数',
                        width : 600,
                        height: 400,
                        modal: true,
                        content:"<iframe src='${proPath}/base/goURL/sysparam/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"
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
                            ids[i] = array[i].sysParamId;
                            // alert(ids[i]);
                        }
                        // alert("ids: "+ids);
                        //锁定整个页面，前面加 parent
                        parent.$.messager.confirm('删除对话框', '确定要删除数据！！！', function (r) {
                            if(r){
                                // alert(r);
                                $.ajax({
                                    url : "${proPath}/sysParam/deleteList.action",
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
                text:"系统参数名称： <input type='text' id='sysParamField' name='sysParamField'/>",
            }],
            columns: [[
                {checkbox:true},
                {field: 'sysParamId', title: '参数编号', width: 100},
                {field: 'sysParamField', title: '参数名称', width: 100},
                {field: 'sysParamValue', title: '参数值', width: 100},
                {field: 'sysParamText', title: '参数内容', width: 100},
                {field: 'sysParamType', title: '参数类型', width: 100, align: 'right'}
            ]]
        });
        $('#sysParamField').searchbox({
            searcher:function(value,name){
                $('#dg').datagrid('load',{
                    sysParamField:'%'+value+'%'
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