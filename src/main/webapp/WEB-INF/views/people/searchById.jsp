<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored = "false" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
<p>Id: ${person.id}</p>
<p>Name: ${person.name}</p>
<p>First Name: ${person.lastName}</p>
<p>Age: ${person.age}</p>
<p>Email: ${person.email}</p>

<a href="/people/${person.id}/edit">Edit</a>

<form method="post" action="/people/${person.id}">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="Delete">
</form>
</body>
</html>
