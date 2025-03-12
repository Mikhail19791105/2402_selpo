<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="static by.itclass.constants.Constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=MENU_JSP%>"/>
    <jsp:include page="<%=SLIDER%>"/>
    <script src="/jsp/slider.js"></script>

</body>
</html>
