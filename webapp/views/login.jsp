<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are not login. </title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Please, login first !!!</h1>
</div>

<div class="w3-container w3-padding">
    <%--<%
        if (request.getAttribute("userName") != null) {
            out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                    "   <h5>User '" + request.getAttribute("userName") + "' added!</h5>\n" +
                    "</div>");
        }
    %>--%>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Enter you login and password</h2>
        </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Login:
                <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>
            <label>Password:
                <input type="password" name="password" class="w3-input w3-animate-input w3-border w3-round-large"
                       style="width: 30%"><br/>
            </label>

            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
    <c:if test="${sessionScope.userName != null}">
        <div class="w3-red w3-center">
            <h2>Your login or password is incorrect</h2>
        </div>
    </c:if>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
