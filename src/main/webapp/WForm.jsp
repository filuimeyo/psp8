<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 30.11.2023
  Time: 15:19
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
<h3>${title}</h3>

<div>
    <form action="editW" method="post">

        <input type="text" value='${brand}' name="brand" required>

        <select name="selectedType" required>
            <option disabled="true" >Выберите тип часов</option>
            <c:forEach var="type" items="${types}">
                <option value=${type}><c:out value="${type}" /></option>
            </c:forEach>
        </select>

        <input name="price" type="number" step="0.01" min="0.01" value='${price}' required>
        <input name="quantity" type="number" step="1" min="0" value='${quantity}' required>


        <select name="selectedManufactorer" required>
            <option disabled="true" >Выберите производителя</option>
            <c:forEach var="manufactorer" items="${manufactorers}">
                <option value=${manufactorer.getId()}><c:out value="${manufactorer.getName()}, ${manufactorer.getCountry()}" /></option>
            </c:forEach>
        </select>
        <input type="submit">
    </form>
</div>
<button><a href="/example">назад</a></button>

</body>
</html>
