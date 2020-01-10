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
    <title>修改供应商</title>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="supId">供应商编号：<input type="text" name="supId" readonly="readonly"/></label>

        </div>
        <div>
            <label for="supName">供应商名称：</label>
            <input type="text" name="supName" />
        </div>
        <div>
            <label for="supLinkman">供应商联系人：</label>
            <input type="text" name="supLinkman" />
        </div>
        <div>
            <label for="supPhone">供应商联系电话：</label>
            <input type="text" name="supPhone" />
        </div>
        <div>
            <label for="supAddress">供应商地址：</label>
            <input type="text" name="supAddress" />
        </div>
        <div>
            <label for="supPay">期初应付（元）：</label>
            <input type="text" name="supPay" />
        </div>
        <div>
            <label for="supType">供应商类型：</label>
            <select id="cc" class="easyui-combobox" name="supType" style="width: 200px;">
                <c:forEach items="${applicationScope.sysParam.supType}" var="supType">
                    <option value="${supType.key}">${supType.value}</option>
                </c:forEach>
            </select>

        </div>
        <div>
            <label for="supRemark">备注：</label>
            <input type="text" name="supRemark" />
        </div>
        <div>
            <input id="btn" type="button" value="提交" align="center" />
        </div>
    </form>

    <script type="text/javascript">
        $(function () {
            //返回 ifram 页面窗体对象window
            var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow;

            var row = win.$('#dg').datagrid("getSelected");
            // alert(row.supId);

            $('#ff').form('load',{
                supId:row.supId,
                supName:row.supName,
                supLinkman:row.supLinkman,
                supPhone:row.supPhone,
                supAddress:row.supAddress,
                supPay:row.supPay,
                supType:row.supType,
                supRemark:row.supRemark

            });

            $("[name='supId']").validatebox({
                required : true,
                missingMessage : '请填写供应商ID！！！'
            });
            $("[name='supName']").validatebox({
                required : true,
                missingMessage : '请填写供应商！！！'
            });
            $("[name='supLinkman']").validatebox({
                required : true,
                missingMessage : '请填写供应商联系人！！！'
            });
            $("[name='supPhone']").validatebox({
                required : true,
                missingMessage : '请填写供应商联系电话！！！'
            });
            //禁用验证
            $("#ff").form("disableValidation");

            $("#btn").click(function () {
                // alert("btn提交按钮。。。");
                $("#ff").form("enableValidation");
                if($("#ff").form("validate")){
                    $('#ff').form('submit',{
                        url : '${proPath}/supplier/update.action',
                        onSubmit : function () {
                            return true;
                        },
                        success : function (count) {
                            //课定义为 对应 消息框
                            if(count>0){
                                alert("修改成功！！！");
                            }else {
                                alert("修改失败！！！")
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
