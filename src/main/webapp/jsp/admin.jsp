<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static by.itclass.constants.Constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%=MENU_JSP%>"/>
<div class="form-box">
    <form method="post" action="<%=ADMIN_CONTROLLER%>">
        <input name="<%=LOGIN_PARAM%>" placeholder="login" required>
        <input type="submit" value="Find">
    </form>
</div>
</body>
</html>
