<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 29.11.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Watch</title>
</head>

<link rel="stylesheet" type="text/css" href="css/style.css"/>
<body>
<div class="wrapper">
    <form action="example" method="post">


        <label for="mechPrice">Max mechanical price:</label>
        <input type="number" step="0.01" id="mechPrice" name="mechPrice">
        <br>

        <input type="submit" value="Submit">
    </form>

    <table>
        <tr>
            <th>id</th>
            <th>бренд</th>
            <th>тип</th>
            <th>цена</th>
            <th>количество</th>
            <th>производитель</th>
            <th></th>
        </tr>
        <c:forEach var="product" items="${watches}">
            <tr>
                <td><c:out value="${product.getId()}" /></td>
                <td><c:out value="${product.getBrand()}" /></td>
                <td><c:out value="${product.getType()}" /></td>
                <td><c:out value="${product.getPrice()}" /></td>
                <td><c:out value="${product.getQuantity()}" /></td>
                <td><c:out value="${product.getManufacturer().getName()}, ${product.getManufacturer().getCountry()}" /></td>
                <td>
                    <a href='/editW?id=${product.getId()}'>&#x270E;</a>
                    <a href='/deleteW?id=${product.getId()}'>&#x2718;</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <button><a href="/brand">производители</a></button>
    <button><a href="/editW">добавить</a></button>
</div>

</body>
</html>
