<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="static by.itclass.constants.Constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Receipt </title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=MENU_JSP%>"/>
<div class="receipt-container">
    <h2>Order id: ${orderReceipt.order.id}</h2>
    <h2>Order date: ${orderReceipt.order.date}</h2>
    <h2>Delivery address: ${orderReceipt.order.address}</h2>
    <h2 class="underLine">Yor ordered:</h2>
    <c:forEach var="item" items="${orderReceipt.receiptItems}">
        <h2>${item.quantity} ${item.itemInfo} by ${item.itemPrice} byn. Amount : ${item.itemAmount} byn.</h2>
    </c:forEach>
    <h2 class="underLine">Total amount: ${orderReceipt.total} byn.</h2>
</div>
</body>
</html>
