<%@ page language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Mlpk</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            </li>
        </ul>
        <%
            if (isLogged) {
        %>
        <form class="form-inline my-2 my-lg-0">
            <a href="Logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
        </form>
        <%
            }
        %>
    </div>
</nav>