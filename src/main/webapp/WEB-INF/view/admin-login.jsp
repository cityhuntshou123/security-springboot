<%@ page contentType="text/html; UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<form action="login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    用户名:<input type="text" name="username"><br/>
    密&nbsp;&nbsp;码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>