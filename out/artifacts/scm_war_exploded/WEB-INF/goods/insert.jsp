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
    <title>新增商品</title>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="goodsId">商品编号：<input type="text" name="goodsId" /></label>

        </div>
        <div>
            <label for="goodsName">商品名称：</label>
            <input type="text" name="goodsName" />
        </div>
        <div>
            <label for="goodsUnit">商品单位：</label>
            <input type="text" name="goodsUnit" />
        </div>
        <div>
            <label for="goodsType">商品类型：</label>
            <input type="text" name="goodsType" />
        </div>
        <div>
            <label for="goodsColor">商品颜色：</label>
            <select id="goodsColor" class="easyui-combobox" name="goodsColor" style="width: 200px;">
                <c:forEach items="${applicationScope.sysParam.goodsColor}" var="goodsColor">
                    <option value="${goodsColor.key}">${goodsColor.value}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="goodsStore">商品仓库：</label>
            <select id="goodsStore" class="easyui-combobox" name="goodsStore" style="width: 200px;">
                <c:forEach items="${applicationScope.sysParam.shId}" var="shId">
                    <option value="${shId.key}">${shId.value}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="goodsLimit">商品下限：</label>
            <input type="text" name="goodsLimit" />
        </div>
        <div>
            <label for="goodsCommission">商品提成：</label>
            <input type="text" name="goodsCommission" />
        </div>
        <div>
            <label for="goodsProducer">生产厂家：</label>
            <input type="text" name="goodsProducer" />
        </div>
        <div>
            <label for="goodsRemark">备注：</label>
            <input type="text" name="goodsRemark" />
        </div>
        <div>
            <label for="goodsSelPrice">商品售价（元）：</label>
            <input type="text" name="goodsSelPrice" />
        </div>
        <div>
            <label for="goodsBuyPrice">商品进价（元）：</label>
            <input type="text" name="goodsBuyPrice" />
        </div>
<%--        <div>--%>
<%--            <label for="supType">供应商类型：</label>--%>
<%--            <select id="cc" class="easyui-combobox" name="supType" style="width: 200px;">--%>
<%--                <c:forEach items="${applicationScope.sysParam.supType}" var="supType">--%>
<%--                    <option value="${supType.key}">${supType.value}</option>--%>
<%--                </c:forEach>--%>
<%--            </select>--%>

<%--        </div>--%>

        <div>
            <input id="btn" type="button" value="提交" align="center" />
        </div>
    </form>

    <script type="text/javascript">
        $(function () {
            //返回 ifram 页面窗体对象window
            var win = parent.$("iframe[title='商品管理']").get(0).contentWindow;

            $("[name='goodsId']").validatebox({
                required : true,
                missingMessage : '请填写商品编号！！！'
            });
            $("[name='goodsName']").validatebox({
                required : true,
                missingMessage : '请填写商品名称！！！'
            });
            $("[name='goodsUnit']").validatebox({
                required : true,
                missingMessage : '请填写商品单位！！！'
            });

            //禁用验证
            $("#ff").form("disableValidation");

            $("#btn").click(function () {
                // alert("btn提交按钮。。。");
                $("#ff").form("enableValidation");
                if($("#ff").form("validate")){
                    $('#ff').form('submit',{
                        url : '${proPath}/goods/insert.action',
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
