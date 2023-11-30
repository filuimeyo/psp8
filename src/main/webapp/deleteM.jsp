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
    <form action="deleteM" method="post">
        <h3>Удалить?</h3>
        <input type="submit" value="Submit">
    </form>



    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>country</th>

            <td>
            </td>

        </tr>

        <tr>
            <td name="id"><c:out value="${id}" /></td>
            <td name="name"><c:out value="${name}" /></td>
            <td name="country"><c:out value="${country}" /></td>

            <td>

            </td>

        </tr>
    </table>


</div>
<button><a href="/brand">назад</a></button>

</body>
</html>
