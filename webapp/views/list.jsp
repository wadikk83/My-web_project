<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Вадим
  Date: 01.07.2020
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List user</title>
</head>
<body>
<%
    List<String> names = (List<String>) request.getAttribute("userNames");

    if (names != null && !names.isEmpty()) {
        out.println("<ui>");
        for (String s : names) {
            out.println("<li>" + s + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no users yet!</p>");
%>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
