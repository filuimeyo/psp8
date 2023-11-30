<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 30.11.2023
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<body>

<div class="wrapper">
    <form action="deleteW" method="post">
        <h3>Удалить?</h3>
        <input type="submit" value="Submit">
    </form>

    <table>
        <tr>
            <th>id</th>
            <th>бренд</th>
            <th>тип</th>
            <th></th>
        </tr>

        <tr>
            <td name="id"><c:out value="${id}"/></td>
            <td name="brand"><c:out value="${brand}"/></td>
            <td name="type"><c:out value="${type}"/></td>

            <td>

            </td>
        </tr>

    </table>

    <button><a href="/example">назад</a></button>
</div>



</body>
</html>
