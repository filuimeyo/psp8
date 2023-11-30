<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<body>

    <p>filters:</p>
    <form method="POST" action="TextServlet">
        <input name="price" type="number" step="0.01">
    </form>
    <h1>Parameter Value: ${param}</h1>

    <c:forEach var="product" items="${watches}">
        <div class="product">
            <h4><c:out value="${product.getBrand()}" /></h4>
        </div>
    </c:forEach>
</body>
</html>
