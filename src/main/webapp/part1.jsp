<%--
  Created by IntelliJ IDEA.
  User: nikak
  Date: 30.11.2023
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    textarea {
        resize: none;
        overflow: hidden;
        width: 600px;
    }
</style>
<body>

    <form method="post" action="font">
        <input name="fontSize" value="${fontSize}" required/>
        <input name="number" value="${number}" required/>
        <input type="submit" value="применить">
    </form>

    <textarea name="text"  rows="${number}"  style="font-size: ${fontSize}px" readonly>
        ${text}
    </textarea>

</body>
</html>
