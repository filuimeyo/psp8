<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 30.11.2023
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Manufactorer</title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<body>

<div class="wrapper">
    <form action="brand" method="post">

        <select name="selectedType">
            <option disabled="true" selected="true">Выберите тип часов</option>
            <c:forEach var="type" items="${types}">
                <option value=${type}><c:out value="${type}" /></option>
            </c:forEach>
        </select>
        <br>

        <select name="selectedCountry">
            <option disabled="true" selected="true">Выберите страну</option>
            <c:forEach var="country" items="${countries}">
                <option value=${country}><c:out value="${country}" /></option>
            </c:forEach>
        </select>
        <br>
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

        <c:forEach var="manufactorer" items="${manufactorers}">

            <tr>
                <td><c:out value="${manufactorer.getId()}" /></td>
                <td><c:out value="${manufactorer.getName()}" /></td>
                <td><c:out value="${manufactorer.getCountry()}" /></td>

                <td>
                    <a href='/editM?id=${manufactorer.getId()}'>&#x270E;</a>
                    <a  href='/deleteM?id=${manufactorer.getId()}'>&#x2718;</a>
                </td>

            </tr>
        </c:forEach>
    </table>

    <button><a href="/example">каталог часов</a></button>
    <button><a href="/editM">добавить</a></button>

</div>


</body>
</html>
