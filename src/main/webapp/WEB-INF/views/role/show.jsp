<%-- 
    Document   : show
    Created on : 4 Aug, 2020, 8:31:49 AM
    Author     : acer
--%>
<%@page import="java.io.File"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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


        <div class="container mt-5">
            <a href="form"><button class="btn btn-sm btn-success" type="button">Add more</button></a>
            <a href="permission"><button class="btn btn-sm btn-success" type="button">Permissions</button></a>
            <a href="/role/assign"><button class="btn btn-sm btn-success" type="button">Assign Role to user</button></a>

            <table class="table table-condensed tble-bordered">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>

                </tr>
                <c:forEach items="${roles}" var="role">     
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>${role.description}</td>
                        <td><a  href="update?id=${role.id}"><button class="btn btn-sm btn-warning">Update</button></a></td>
                        <td><a  href="delete?id=${role.id}"><button class="btn btn-sm btn-danger">Delete</button></a></td>
                    </tr>
                </c:forEach>



            </table>
        </div>

    </body>
</html>
