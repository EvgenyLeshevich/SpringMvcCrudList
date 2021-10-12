<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored = "false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All People</title>
</head>
<body>
<c:forEach var="person" items="${people}">
    <p><a href="/people/${person.id}">${person.name} ${person.lastName}</a></p>
</c:forEach>

<br/>
<hr/>
<a href="/people/new">Create new person</a>
</body>
</html>
