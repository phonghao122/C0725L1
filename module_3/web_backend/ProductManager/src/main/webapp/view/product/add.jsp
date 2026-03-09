<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=add" method="post">
    <input name="id"><br>
    <input name="name"><br>
    <input name="price"><br>
    <input name="quantity"><br>
    <button>Thêm mới</button>
</form>
</body>
</html>