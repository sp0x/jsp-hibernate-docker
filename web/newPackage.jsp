<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Index</title>
    <jsp:directive.include file="static_head.jsp"/>
</head>
<%
    String username = (String) session.getAttribute("user");
    boolean isLogged = username != null;
%>
<body>
<div class="container">
    <div class="">
        <%
            if (isLogged) {
        %>
        <h1>Create a new package</h1>
        <form action="createPackage" method="POST">
            <div class="form-group">
                <label for="name">Name: </label>
                <input id="name" type="text" name="name" class="form-control">
            </div>
            <div class="form-group">
                <label for="language">Language: </label>
                <input id="language" type="text" name="language" class="form-control">
            </div>
            <input type="submit" class="btn btn-primary"> <br/>
        </form>
        <%
        } else {
        %>
        <h2>You need to Log in first!</h2>
        <a class="btn btn-primary" href="login.jsp">Login</a>
        <br/> <br/>
        <%
            }
        %>
        <h2></h2>
    </div>
</div>
</body>
</html>
