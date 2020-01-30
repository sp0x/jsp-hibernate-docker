<%--
  Created by IntelliJ IDEA.
  User: cyb3r
  Date: 29-Jan-20
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%
    String u1 = (String) session.getAttribute("user");
    boolean l1 = u1 != null;
    if (l1) {
%>
<ul>

</ul>
<%
    }
%>

