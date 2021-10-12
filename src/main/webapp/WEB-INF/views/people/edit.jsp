<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Update Person</title>
</head>
<body>
<form method="post" action="/people/${person.id}">
    <input type="hidden" name="_method" value="PATCH"> <%-- Скрытое поле для изменения метода на patch --%>
    <%-- method - с каким http-методом будет отправляться эта форма --%>
    <%-- action - на какой адрес эта форма будет обращаться, куда она будет передавать данные --%>
    Name: <input type="text" name="name" value="${person.name}">
    <br/>
    Last Name: <input type="text" name="lastName" value="${person.lastName}">
    <br/>
    Age: <input type="text" name="age" value="${person.age}">
    <br/>
    Email: <input type="text" name="email" value="${person.email}">
    <br/>
    <input type="submit" value="Update">
</form>
</body>
</html>
