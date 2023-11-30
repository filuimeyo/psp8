<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 30.11.2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<body>

    <h3>${title}</h3>

    <div>
        <form action="editM" method="post">
            <input type="text" name="name" value='${name}' required>
            <input type="text" name="country" value='${country}' required>


            <input type="submit">
        </form>
    </div>
    <a href="/brand">производители</a>
</body>
</html>

