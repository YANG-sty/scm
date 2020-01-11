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
    <title>新增仓库</title>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="shId">仓库编号：</label>
            <input type="text" name="shId" />
        </div>
        <div>
            <label for="shName">仓库名称：</label>
            <input type="text" name="shName" />
        </div>
        <div>
            <label for="shResponsible">责 任 人 ：</label>
            <input type="text" name="shResponsible"/>
        </div>
        <div>
            <label for="shPhone">联系方式：</label>
            <input type="text" name="shPhone" />
        </div>
        <div>
            <label for="shAddress">仓库地址：</label>
            <input type="text" name="shAddress" />
        </div>
        <div>
            <label for="shType">仓库类型：</label>
            <input type="text" name="shType" />
        </div>
        <div>
            <label for="shRemark">备注信息：</label>
            <input type="text" name="shRemark" />
        </div>
        <div>
            <input id="btn" type="button" value="提交" align="center" />
        </div>
    </form>

    <script type="text/javascript">
        $(function () {
            //返回 ifram 页面窗体对象window
            var win = parent.$("iframe[title='仓库管理']").get(0).contentWindow;

            $("[name='shId']").validatebox({
                required : true,
                missingMessage : '请填写仓库编号！！！'
            });
            $("[name='shName']").validatebox({
                required : true,
                missingMessage : '请填写仓库名称！！！'
            });
            $("[name='shResponsible']").validatebox({
                required : true,
                missingMessage : '请填写责任人！！！'
            });
            $("[name='shPhone']").validatebox({
                required : true,
                missingMessage : '请填写联系方式！！！'
            });
            $("[name='shAddress']").validatebox({
                required : true,
                missingMessage : '请填写仓库地址！！！'
            });
            $("[name='shType']").validatebox({
                required : true,
                missingMessage : '请填写仓库类型！！！'
            });

            //禁用验证
            $("#ff").form("disableValidation");

            $("#btn").click(function () {
                // alert("btn提交按钮。。。");
                $("#ff").form("enableValidation");
                if($("#ff").form("validate")){
                    $('#ff').form('submit',{
                        url : '${proPath}/storeHouse/insert.action',
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
