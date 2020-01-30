<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <jsp:directive.include file="static_head.jsp"/>
</head>
<body>
<div class="container">
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <div class="alert-danger"><%= error %></div>
    <%
        }
    %>
    <%
        if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null) {
    %>
    Enter Username and Email ID using POST method
    <h3>Notice the queryString is not present in the URL as the query string is sent in the body</h3>
    <form action="login" method="post">
        <div class="form-group">
            <label for="1">Username: </label>
            <input id="1" class="form-control" type="text" name="user"><br/>
        </div>
        <div class="form-group">
            <label for="2">Password: </label>
            <input id="2" class="form-control" type="password" name="password"><br/>
        </div>
        <input type="submit" class="btn btn-primary"> <br/>
    </form>
    <%
    } else {
    %>
    <h3>Enter your credentials.</h3>
    <form action="login" method="post">
        <div class="form-group">
            <label for="1">Username: </label>
            <input id="1" class="form-control" type="text" name="user"><br/>
        </div>
        <div class="form-group">
            <label for="2">Password: </label>
            <input id="2" class="form-control" type="password" name="password"><br/>
        </div>
        <input type="submit" class="btn btn-primary"> <br/>
    </form>
    <%
        }
    %>
</div>
</body>
</html>
