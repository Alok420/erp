<%@page import="com.opamg.erp.beans.User"%>
<%
    User user = (User) session.getAttribute("user");
%>
<nav class="navbar navbar-expand-md navbar-dark" style="height: 30px; background-color: #1560bd">
    <a class="navbar-brand" style="font-size: 15px" href="./">Build Nation Through Opam<b><span style="font-size: 18px">G</span></b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="./../">Dashboard</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <%
                    if (user != null) {
                %>
                <div class="dropdown">
                    <button class="btn dropdown-toggle" style="height: 25px; padding: 0px 0px 0px 3px; font-size: 13px; font-weight: 500; background-color: whitesmoke; color:#1560bd " type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <%= user.getEmail()%>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="./../">Dashboard</a>
                        <a class="dropdown-item" href="#">Profile</a>
                        <a class="dropdown-item" href="#">Setting</a>
                        <a class="dropdown-item" href="./../../logout">Logout</a>
                    </div>
                </div>
                <%
                } else {
                    response.sendRedirect("./../login");
                %>
                <a class="nav-link" href="./login">Login</a>
                <%
                    }
                %>
            </li>


        </ul>
    </div>
</nav>