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
            <h1>Permissions</h1>
            <a href="/role/show" class="btn btn-success btn-sm"> << </a>

            <form method="post" action="/permission/save">   
                <div class="form-group">
                    <label for="exampleInputEmail1">Select module</label>
                    <select class="form-control" name="type">
                        <option>Flower</option>
                        <option>Fruit</option>
                        <option>MyBranch</option>
                        <option>Leaf</option>
                        <option>Root</option>
                        <option>Sprig</option>
                        <option>Seed</option>
                        <option>Trunk</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Select Role</label>
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
                                <th>Module</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${permissions}" var="permission">
                                <tr>
                                    <td>${permission.id}</td>
                                    <td>${permission.type}</td>
                                    <td>${permission.role.name}</td>
                                    <td><a href="/permission/delete?id=${permission.id}">Remove </a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
