<%--
  Created by IntelliJ IDEA.
  User: HELLO
  Date: 09/03/2026
  Time: 7:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/add" method="post">
    <input name="id" type="number" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="number" name="age" placeholder="age">
    <select name="gender">
        <option value="Male">male</option>
        <option value="Female">female</option>
    </select>
    <button type="submit">Add</button>
</form>
</body>
</html>
