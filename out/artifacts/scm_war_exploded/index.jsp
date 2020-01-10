<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>add</title>
</head>
<body>
	<form action="department/insert.action" method="post">
		部门名称：<label>
        <input type="text"	name="deptName">
    </label><br>
		部门地址：<input type="text" name="deptAddress"><br>
		<input type="submit" value="ok">
	</form>
</body>
</html>
