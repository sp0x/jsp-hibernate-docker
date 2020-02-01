<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:directive.include file="navbar.jsp"/>

<div class="container">
    <c:if test="${not empty error}">
        <div class="alert-danger"><%= error %></div>
    </c:if>
    <div class="jumbotron">
        <h1>Machine learning package manager</h1>
        <%
            if (isLogged) {
        %>
        <h2>Hello <%= username %>!</h2>
        <p>Here you can see all the packages we have.</p>
        <%
        } else {
        %>
        <a class="btn btn-primary" href="login.jsp">Login</a>
        <br/> <br/>
        <%
            }
        %>
        <h2></h2>
    </div>
    <%
        if (isLogged) {
    %>
    <jsp:directive.include file="packages.jsp"/>
    <%
        }
    %>
</div>
</body>
</html>
