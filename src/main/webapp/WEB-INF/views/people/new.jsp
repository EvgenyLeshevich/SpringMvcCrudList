<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Person</title>
</head>
<body>

<form method="post" action="/people">
    <%-- method - с каким http-методом будет отправляться эта форма --%>
    <%-- action - на какой адрес эта форма будет обращаться, куда она будет передавать данные --%>
    Name: <input type="text" name="name">
    <br/>
    Last Name: <input type="text" name="lastName">
    <br/>
    Age: <input type="text" name="age">
    <br/>
    Email: <input type="text" name="email">
    <br/>
    <input type="submit" value="Create">
</form:errors>

</body>
</html>
