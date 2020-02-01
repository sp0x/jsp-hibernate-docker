<%@ page import="com.mlpk.repos.UserRepository" %>
<%@ page import="com.mlpk.repos.PackageRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mlpk.models.Package" %><%--
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
        PackageRepository repo = new PackageRepository();
        List<Package> packages = repo.getPackages();
%>
<a class="btn btn-info" href="newPackage.jsp">Add new package</a>
<ul class="packages">
    <%
        for (Package pkg :
                packages) {
            boolean isOwn = pkg.isOwn((Long) session.getAttribute("userId"));
    %>
    <li class="package">
        <div class="name"><%= pkg.getName() %>
        </div>
        <div class="language"><%= pkg.getLanguage()%>
        </div>
        <%
            if (isOwn) {
        %>
        <div class="del">
            <a href="DeletePackage?id=<%= pkg.getId() %>">Delete</a>
        </div>
        <%
            }
        %>
    </li>
    <%
        }
    %>
</ul>
<%
    }
%>

