<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/22
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ include file="/common/common.jsp"%>
<html>
<head>
    <title>新增参数</title>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="goodsId">参数编号：</label>
            <input type="text" name="goodsId" />
        </div>
        <div>
            <label for="sysParamField">参数名称：</label>
            <input type="text" name="sysParamField" />
        </div>
        <div>
            <label for="sysParamValue">参 数 值 ：</label>
            <input type="text" name="sysParamValue"/>
        </div>
        <div>
            <label for="sysParamText">参数内容：</label>
            <input type="text" name="sysParamText" />
        </div>
        <div>
            <label for="sysParamType">参数类型：</label>
            <input type="text" name="sysParamType" />
        </div>
        <div>
            <input id="btn" type="button" value="提交" align="center" />
        </div>
    </form>

    <script type="text/javascript">
        $(function () {
            //返回 ifram 页面窗体对象window
            var win = parent.$("iframe[title='参数管理']").get(0).contentWindow;

            $("[name='sysParamId']").validatebox({
                required : true,
                missingMessage : '请填写参数编号！！！'
            });
            $("[name='sysParamField']").validatebox({
                required : true,
                missingMessage : '请填写参数名称！！！'
            });
            $("[name='sysParamValue']").validatebox({
                required : true,
                missingMessage : '请填写参数值！！！'
            });

            //禁用验证
            $("#ff").form("disableValidation");

            $("#btn").click(function () {
                // alert("btn提交按钮。。。");
                $("#ff").form("enableValidation");
                if($("#ff").form("validate")){
                    $('#ff').form('submit',{
                        url : '${proPath}/sysParam/insert.action',
                        onSubmit : function () {
                            return true;
                        },
                        success : function (count) {
                            //课定义为 对应 消息框
                            if(count>0){
                                alert("添加成功！！！");
                            }else {
                                alert("添加失败！！！")
                            }
                            parent.$("#win").window("close");
                            win.$("#dg").datagrid("reload");
                        }
                    });
                }
            });

        });
    </script>
</body>
</html>
