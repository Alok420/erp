<%-- 
    Document   : update
    Created on : 4 Aug, 2020, 8:32:35 AM
    Author     : acer
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.opamg.erp.DAO.repo.RoleRepository"%>
<%@page import="com.opamg.erp.DAO.service.RoleService"%>
<%@page import="com.opamg.erp.beans.Role"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="com.opamg.erp.DAO.service.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Show all</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../common/header.jsp" %>

        <h3 style="text-align: center;">Update user</h3>
        <div class="container-fluid" style="overflow: scroll;">
            <form action="update" method="POST">
                <input type="hidden" name="id" value="${user.id}">
                <input type="text" id="fname" value="${user.first_name}" class="form-control" placeholder="Enter your first name" required autofocus name="first_name">
                <input type="text" id="lname" value="${user.last_name}" class="form-control" placeholder="Enter youtr last name" required autofocus name="last_name">
                <input type="text" value="${user.contact}" id="contact" class="form-control" placeholder="Your contact" required autofocus name="contact">
                <input type="text" value="${user.address}" id="contact" class="form-control" placeholder="Your Address" required autofocus name="address">
                <input type="email" id="inputEmail" value="${user.email}" name="email" class="form-control" placeholder="Email address" required autofocus>
                <select name="role" class="form-control">
                    <%                        Set<Role> hs = user.getRole();
                        Role role = (Role) hs.iterator().next();
                    %>
                    <option selected value="<%= role.getName()%>">
                        <%= role.getName()%>
                    </option>
                    <c:forEach items="${roles}" var="role">  
                        <option value="${role.name}">${role.name}</option>
                    </c:forEach>
                </select>
                <br>
                <!--<label for="inputPassword" class="sr-only">Password</label>-->
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

    </body>
</html>