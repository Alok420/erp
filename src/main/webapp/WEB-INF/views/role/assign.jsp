<%-- 
    Document   : permission
    Created on : Jul 20, 2021, 8:16:12 AM
    Author     : bitsi
--%>
<%@page import="java.io.File"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <body>
          <%@include file="../common/header.jsp" %>

        <div class="container">
            <h1>Assign roles to user</h1>
            <a href="/role/show" class="btn btn-success btn-sm"> << </a>
            <form method="post" action="/role/assign">   
                <div class="form-group">
                    <label for="">Select User</label>
                    <select class="form-control" name="user_id">
                        <c:forEach items="${users}" var="user">
                            <option value="${user.id}">${user.first_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="">Select Role</label>
                    <select name="role_id" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <div>
                <h3>All permissions
                </h3>
                <div>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>User Name</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.first_name}</td>
                                    <td>    
                                        <c:forEach items="${user.role}" var="r">

                                            ${r.name}
                                            <a href="/role/remove_from_user?id=${user.id}&role=${r.id}">Remove </a>
                                            <br>
                                        </c:forEach> 
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
