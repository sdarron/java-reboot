<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Расчет</title>
</head>
<body>

<h1>Результат</h1>

<%
    double profit = (double) request.getAttribute("profit");
    out.write("Итоговая сумма " + profit + " рублей.");
%>

<hr/>
</body>
</html>